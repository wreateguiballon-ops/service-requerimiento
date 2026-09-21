package pe.gob.sat.servicio.seguridad.service;

import jakarta.persistence.Tuple;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import pe.gob.sat.servicio.seguridad.dto.UsuarioResponseDto;
import pe.gob.sat.servicio.seguridad.dto.UsuarioRequestDto;
import pe.gob.sat.servicio.seguridad.repository.UsuarioRepository;
import java.util.List;

import static pe.gob.sat.servicio.seguridad.util.DataMapperUtils.*;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {
    private final UsuarioRepository usuarioRepository;

    @Override
    @Transactional(readOnly = true)
    public List<UsuarioResponseDto> consultarUsuario(UsuarioRequestDto request) {
        int tipBus = request.getSiTipBus() != null ? request.getSiTipBus() : 0;
        String xmlParam = request.toXmlParam();
        List<Tuple> tabla = usuarioRepository.consultarUsuario(xmlParam);
        if (tabla == null || tabla.isEmpty()){
            return  List.of();
        }
        return switch (tipBus) {
            case 1 -> tabla.stream().map( tuple -> UsuarioResponseDto.builder()
                        .NumeroRoles(toInteger(tuple.get("NumeroRoles")))
                        .iCodigo_Per(toInteger(tuple.get("iCodigo_Per")))
                        .NombreCompleto(parseString(tuple.get("NombreCompleto")))
                        .cCodPer(parseString(tuple.get("cCodPer")))
                        .build()).toList();

            case 2 -> tabla.stream().map( tuple ->  UsuarioResponseDto.builder()
                        .iCodigo_Per(toInteger(tuple.get("iCodigo_Per")))
                        .cCodPer(parseString(tuple.get("CCODPER")))
                        .vUsuWin(parseString(tuple.get("VUSUWIN")))
                        .vNumDni(parseString(tuple.get("VNUMDNI")))
                        .vNombre(parseString(tuple.get("VNOMBRE")))
                        .vApePat(parseString(tuple.get("VAPEPAT")))
                        .vApeMat(parseString(tuple.get("VAPEMAT")))
                        .nCodUo(toInteger(tuple.get("NCODUO")))
                        .vDesLuo(parseString(tuple.get("VDESLUO")))
                        .nCodCar(toInteger(tuple.get("NCODCAR")))
                        .vDesCar(parseString(tuple.get("VDESCAR")))
                        .vNomEst(parseString(tuple.get("VNOMEST")))
                        .vNomCat(parseString(tuple.get("VNOMCAT")))
                        .vCorreo(parseString(tuple.get("VCORREO")))
                        .siCodigoRol(toInteger(tuple.get("siCodigo_Rol")))
                        .vNombreRol(parseString(tuple.get("vNombre_Rol")))
                        .iCodigo_PerRol(toInteger(tuple.get("iCodigo_PerRol")))
                        .iCodigo_TipoRol(toInteger(tuple.get("iCodigo_TipoRol")))
                        .vNombre_TipoRol(parseString(tuple.get("vNombre_TipoRol")))
                        .build()).toList();
            default -> throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Tipo de búsqueda no soportado: " + tipBus
            );
        };
    }

    @Override
    @Transactional
    public List<UsuarioResponseDto> RegistrarInicioSesion(UsuarioRequestDto request) {
        String xmlParam = request.toXmlParam();
        List<Tuple> tabla = usuarioRepository.RegistrarInicioSesion(xmlParam);
        if (tabla == null || tabla.isEmpty()){
            return  List.of();
        }
        return tabla.stream().map(tuple -> UsuarioResponseDto.builder()
                .iCodigo_Ing((toInteger(tuple.get("iCodigo_Ing"))))
                .build()).toList();
    }
}