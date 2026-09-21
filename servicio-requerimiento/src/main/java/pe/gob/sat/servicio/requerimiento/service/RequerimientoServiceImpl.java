package pe.gob.sat.servicio.requerimiento.service;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Tuple;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.hibernate.boot.beanvalidation.IntegrationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pe.gob.sat.servicio.requerimiento.dto.*;
import pe.gob.sat.servicio.requerimiento.dto.request.DocumentoAdjuntoRequestDto;
import pe.gob.sat.servicio.requerimiento.dto.response.DocumentoAdjuntoResponseDto;
import pe.gob.sat.servicio.requerimiento.enums.*;
import pe.gob.sat.servicio.requerimiento.repository.RequerimientoRepository;

import static pe.gob.sat.common.util.DataMapperUtils.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class RequerimientoServiceImpl implements RequerimientoService{

    private final RequerimientoRepository requerimientoRepository;

    @Override
    @Transactional
    public List<?> consultarRequerimiento(RequerimientoConsultarRequestDto request) {
        int tipBus = request.getSiTipBus() != null ? request.getSiTipBus() : 0;
        String xmlParam = request.toXmlParam();
        Map<String, List<Object[]>> tablas = requerimientoRepository.consultarRequerimiento(xmlParam);

        List<Object[]> tabla1 = tablas.getOrDefault("tabla1", List.of());
        List<Object[]> tabla2 = tablas.getOrDefault("tabla2", List.of());

        return switch (tipBus) {
            /*case 1 ->{

            }
            case 2 ->{

            }*/
            case 3 ->{
                if (tabla1.isEmpty() && tabla2.isEmpty()) {
                    yield List.of();
                }
                List<RequerimientoDato1ResponseDto> listaDetalle = tabla1.stream()
                        .map(this::detalle)
                        .toList();

                List<RequerimientoDato2ResponseDto> listaDetalle2 = tabla2.stream()
                        .map(this::detalle2)
                        .toList();

                yield List.of(
                        RequerimientoDatosResponseDto.builder()
                                .detalle(listaDetalle)
                                .detalle2(listaDetalle2)
                                .build()
                );
            }
            /*case 4 ->{

            }
            case 5 ->{

            }*/
            case 6 ->{
                if (tabla1.isEmpty() && tabla2.isEmpty()) {
                    yield List.of();
                }
                List<RequerimientoAdicionales1ResponseDto> listaDetalle = tabla1.stream()
                        .map(this::adicionales1)
                        .toList();

                List<RequerimientoAdicionales2ResponseDto> listaDetalle2 = tabla2.stream()
                        .map(this::adicionales2)
                        .toList();

                yield List.of(
                        RequerimientoAdicionalesResponseDto.builder()
                                .detalle(listaDetalle)
                                .detalle2(listaDetalle2)
                                .build()
                );
            }
            case 7 -> tabla1.isEmpty() ? List.of() : tabla1.stream().map(this::misRequerimientos).toList();
            case 8 -> tabla1.isEmpty() ? List.of() : tabla1.stream().map(this::misPendientes).toList();
            case 9 -> tabla1.isEmpty() ? List.of() : tabla1.stream().map(this::totales).toList();
            default -> throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Tipo de búsqueda no soportado: " + tipBus
            );
        };
    }

    @Override
    @Transactional
    public void registrarRequerimiento(RequerimientoRegistrarRequestDto request) {
        // Llamamos al repositorio para ejecutar el SP de registro
        requerimientoRepository.registrarRequerimiento(request);
    }


    public List<DocumentoAdjuntoResponseDto> ConsultarDocumentoAdjunto(DocumentoAdjuntoRequestDto request) {
        String xmlParam = request.toXmlParam();
        List<Tuple> tabla = requerimientoRepository.ConsultarDocumentoAdjunto(xmlParam);

        return tabla.stream().map(tuple -> DocumentoAdjuntoResponseDto.builder()
                .iNumCor(toInteger( tuple.get("iNumCor", Integer.class)))
                .iCodigo_DocAdj(tuple.get("iCodigo_DocAdj", Integer.class))
                .iCodigo_Req(tuple.get("iCodigo_Req", Integer.class))
                .TipoAdjunto(parseString( tuple.get("TipoAdjunto", String.class)))
                .vNombre_DocAdj(parseString(tuple.get("vNombre_DocAdj", String.class)))
                .vNombreOriginal_DocAdj(parseString( tuple.get("vNombreOriginal_DocAdj",String.class)))
                .vDescripcion_DocAdj(parseString( tuple.get("vDescripcion_DocAdj",String.class)))
                .siEjecucion_DocAdj( tuple.get("siEjecucion_DocAdj", Short.class))
                .Usuario(parseString( tuple.get("Usuario",String.class)))
                .sdFechaCarga_DocAdj(tuple.get("sdFechaCarga_DocAdj", LocalDateTime.class))
                .cNombreTerminal_DocAdj(parseString( tuple.get("cNombreTerminal_DocAdj", String.class)))
                .iCodigo_TipAdj(tuple.get("iCodigo_TipAdj", Integer.class))
                .iCodigo_PerCar_DocAdj(tuple.get("iCodigo_PerCar_DocAdj", Integer.class))
                .build()
        ).toList();
    }

    private RequerimientoMisRequerimientosResponseDto misRequerimientos(Object[] row){
        return RequerimientoMisRequerimientosResponseDto.builder()
                .iCodigo_Req(toInteger(row[misRequerimientos.iCodigo_Req.get()]))
                .sdFecha_Req(toLocalDateTime(row[misRequerimientos.sdFecha_Req.get()]))
                .vDesLUo(parseString(row[misRequerimientos.vDesLUo.get()]))
                .iCodUo(toInteger(row[misRequerimientos.iCodUo.get()]))
                .Solicitante(parseString(row[misRequerimientos.Solicitante.get()]))
                .Categoria(parseString(row[misRequerimientos.Categoria.get()]))
                .SubCategoria(parseString(row[misRequerimientos.SubCategoria.get()]))
                .Prioridad(parseString(row[misRequerimientos.Prioridad.get()]))
                .Estado(parseString(row[misRequerimientos.Estado.get()]))
                .TipoEvaluacion(parseString(row[misRequerimientos.TipoEvaluacion.get()]))
                .siCodigo_Est(toInteger(row[misRequerimientos.siCodigo_Est.get()]))
                .iCodigo_Per(toInteger(row[misRequerimientos.iCodigo_Per.get()]))
                .build();
    }

    private RequerimientoMisPendientesResponseDto misPendientes(Object[] row){
        return  RequerimientoMisPendientesResponseDto.builder()
                .iCodigo_Req(toInteger(row[0]))
                .sdFecha_Req(toLocalDateTime(row[1]))
                .vDesLUo(parseString(row[2]))
                .iCodUo(toInteger(row[3]))
                .Responsable(parseString(row[4]))
                .Prioridad(parseString(row[5]))
                .TipoEvaluacion(parseString(row[6]))
                .Estado(parseString(row[7]))
                .siCodigo_Est(toInteger(row[8]))
                .iCodigo_Per(toInteger(row[9]))
                .vNombre_Cat(parseString(row[10]))
                .vNombre_SubCat(parseString(row[11]))
                .build();
    }
    private RequerimientoContadorResponseDto totales(Object[] row){
        return  RequerimientoContadorResponseDto.builder()
                .iNumReqPendientes (toInteger(row[0]))
                .iNumReqPorAsignar(toInteger(row[1]))
                .iNumReqPorAtender(toInteger(row[2]))
                .iNumReqPorDarConformidad(toInteger(row[3]))
                .iNumReqNoConformes(toInteger(row[4]))
                .iNumMisRequerimientos(toInteger(row[5]))
                .iNumMisRequerimientosRegistrados(toInteger(row[6]))
                .iNumMisRequerimientosPorAsignar(toInteger(row[7]))
                .iNumMisRequerimientosAsignados(toInteger(row[8]))
                .iNumMisRequerimientosEnProceso(toInteger(row[9]))
                .iNumMisRequerimientosAtendidos(toInteger(row[10]))
                .iNumMisRequerimientosCerradosNoAutorizado(toInteger(row[11]))
                .iNumMisRequerimientosCerradosPorSistema(toInteger(row[12]))
                .iNumMisRequerimientosCerradosConforme(toInteger(row[13]))
                .iNumMisRequerimientosCerradosRechazados(toInteger(row[14]))
                .iNumMisRequerimientosCerradosAnulados(toInteger(row[15]))
                .iNumMisRequerimientosNoConformes(toInteger(row[16]))
                .iNumMisRequerimientosCerradosPorRevesion(toInteger(row[17]))
                .build();
    }
    private RequerimientoDato1ResponseDto detalle(Object[] row){
        return  RequerimientoDato1ResponseDto.builder()
                .iCodigo_Req(toInteger(row[0]))
                .sdFecha_Req(toLocalDateTime(row[1]))
                .siCodigo_Est(toInteger(row[2]))
                .vNombre_Est(parseString(row[3]))
                .iCodigo_Pri(toInteger(row[4]))
                .Prioridad(parseString(row[5]))
                .iCodigoPadre_Req(toInteger(row[6]))
                .sdFechaCierre_Req(toLocalDateTime(row[7]))
                .iCodigo_Per(toInteger(row[8]))
                .iCodUo_Ori(toInteger(row[9]))
                .vDesLUo(parseString(row[10]))
                .Solicitante(parseString(row[11]))
                .vDesCar(parseString(row[12]))
                .iCodigo_PerDes_ReqMov(toInteger(row[13]))
                .ResponsableAdministrado(parseString(row[14]))
                .Responsable(parseString(row[15]))
                .bResPrincipal_ReqMov(toBoolean(row[16]))
                .CargoResponsable(parseString(row[17]))
                .iCodigo_UO(toInteger(row[18]))
                .iCodUo(toInteger(row[19]))
                .Ubicacion(parseString(row[20]))
                .iCodigo_TipEva(toInteger(row[21]))
                .TipoEvaluacion(parseString(row[22]))
                .iCodigo_TipEnv(toInteger(row[23]))
                .MedioEnvio(parseString(row[24]))
                .iCodigo_CSC(toInteger(row[25]))
                .siCodigo_Cat(toInteger(row[26]))
                .vNombre_Cat(parseString(row[27]))
                .bInventarioFisico_Cat(toBoolean(row[28]))
                .siCodigo_SubCat(toInteger(row[29]))
                .vNombre_SubCat(parseString(row[30]))
                .iCodigo_TipDocSus(toInteger(row[31]))
                .DocSustento(parseString(row[32]))
                .cNumero_DocSus(parseString(row[33]))
                .TipNoCon(parseString(row[34]))
                .sdFecha_DocSus(toLocalDateTime(row[35]))
                .vDocumentoAdjunto_Req(parseString(row[36]))
                .vCodInv(parseString(row[37]))
                .bAvance_Req(toBoolean( row[38]))
                .bFisico_Req(toBoolean( row[39]))
                .iCodPer(toInteger(row[40]))
                .siCodigo_DId(toInteger(row[41]))
                .vDescripcion_DId(parseString(row[42]))
                .cDocIde(parseString(row[43]))
                .cNumDoc(parseString(row[44]))
                .vDescripcion_Req(parseString(row[45]))
                .vSumilla_Req(parseString(row[46]))
                .vObservacion_Req(parseString(row[47]))
                .iCodigo_TipMod(toInteger(row[48]))
                .TipoModificacion(parseString(row[49]))
                .PriEvalDat(parseString(row[50]))
                .nMontoDeuda_EvalDat(toBigDecimal(row[51]))
                .nMontoPagos_EvalDat(toBigDecimal(row[52]))
                .iNumeroRegistros_EvalDat(toInteger(row[53]))
                .iNumeroPersonas_EvalDat(toInteger(row[54]))
                .vDescripcion_Cla(parseString(row[55]))
                .build();
    }

    private RequerimientoDato2ResponseDto detalle2 (Object[] row){
        return RequerimientoDato2ResponseDto.builder()
                .vUsuWin(parseString(row[0]))
                .vNombre(parseString(row[1]))
                .vDesCar(parseString(row[2]))
                .build();
    }
    //Adicionales
    private RequerimientoAdicionales1ResponseDto adicionales1(Object[] row){
            return  RequerimientoAdicionales1ResponseDto.builder()
                .iCodigo_Req(toInteger(row[Adicionales1.iCodigo_Req.get()]))
                .sdFecha_Req(toLocalDateTime(row[Adicionales1.sdFecha_Req.get()]))
                    .vDescripcion_Req(parseString(row[Adicionales1.vDescripcion_Req.get()]))
                    .iCodigoPadre_Req(toInteger(row[Adicionales1.iCodigoPadre_Req.get()]))
                    .iCodUo(toInteger(row[Adicionales1.iCodUo.get()]))
                    .iCodigo_PerJefeUnidad(toInteger(row[Adicionales1.iCodigo_PerJefeUnidad.get()]))
                    .iCodigo_Per(toInteger(row[Adicionales1.iCodigo_Per.get()]))
                    .vApePatSol(parseString(row[Adicionales1.vApePatSol.get()]))
                    .vApeMatSol(parseString(row[Adicionales1.vApeMatSol.get()]))
                    .vNombreSol(parseString(row[Adicionales1.vNombreSol.get()]))
                    .siCodCarSol(toInteger(row[Adicionales1.siCodCarSol.get()]))
                    .vDesCarSol(parseString(row[Adicionales1.vDesCarSol.get()]))
                    .vDesLUoSol(parseString(row[Adicionales1.vDesLUoSol.get()]))
                    .siCodigo_Est(toInteger(row[Adicionales1.siCodigo_Est.get()]))
                    .vNombre_Est(parseString(row[Adicionales1.vNombre_Est.get()]))
                    .iCodigo_CSC(toInteger(row[Adicionales1.iCodigo_CSC.get()]))
                    .siCodigo_Cat(toInteger(row[Adicionales1.siCodigo_Cat.get()]))
                    .vNombre_Cat(parseString(row[Adicionales1.vNombre_Cat.get()]))
                    .siCodigo_SubCat(toInteger(row[Adicionales1.siCodigo_SubCat.get()]))
                    .vNombre_SubCat(parseString(row[Adicionales1.vNombre_SubCat.get()]))
                    .vDescripcion_Cla(parseString(row[Adicionales1.vDescripcion_Cla.get()]))
                    .iCodigo_TipEva(toInteger(row[Adicionales1.iCodigo_TipEva.get()]))
                    .iCodigo_TipMod(toInteger(row[Adicionales1.iCodigo_TipMod.get()]))
                    .iCodigo_TipAut(toInteger(row[Adicionales1.iCodigo_TipAut.get()]))
                    .iCodigo_ResPrincipal(toInteger(row[Adicionales1.iCodigo_ResPrincipal.get()]))
                    .iCodigo_PerUnidadSuperior(toInteger(row[Adicionales1.iCodigo_PerUnidadSuperior.get()]))
                    .iCodigo_PerResponsable(toInteger(row[Adicionales1.iCodigo_PerResponsable.get()]))
                    .bUnidadPerteneciente(toBoolean(row[Adicionales1.bUnidadPerteneciente.get()]))
                    .SolicitanteAutorizacion(parseString(row[Adicionales1.SolicitanteAutorizacion.get()]))
                    .FechaSolicitudAut(toLocalDateTime(row[Adicionales1.FechaSolicitudAut.get()]))
                    .build();


    }
    private RequerimientoAdicionales2ResponseDto adicionales2(Object[] row){
        return  RequerimientoAdicionales2ResponseDto.builder()
                .cCodPer(toInteger(row[0]))
                .iCodigo_Per(toInteger(row[1]))
                .build();
    }
}
