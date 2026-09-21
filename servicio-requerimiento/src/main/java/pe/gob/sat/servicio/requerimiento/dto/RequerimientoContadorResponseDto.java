package pe.gob.sat.servicio.requerimiento.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequerimientoContadorResponseDto {
    private Integer iNumReqPendientes;
    private Integer iNumReqPorAsignar;
    private Integer iNumReqPorAtender;
    private Integer iNumReqPorDarConformidad;
    private Integer iNumReqPorAutorizar;
    private Integer iNumReqNoConformes;
    private Integer iNumMisRequerimientos;
    private Integer iNumMisRequerimientosRegistrados;
    private Integer iNumMisRequerimientosPorAsignar;
    private Integer iNumMisRequerimientosAsignados;
    private Integer iNumMisRequerimientosEnProceso;
    private Integer iNumMisRequerimientosAtendidos;
    private Integer iNumMisRequerimientosCerradosNoAutorizado;
    private Integer iNumMisRequerimientosCerradosPorSistema;
    private Integer iNumMisRequerimientosCerradosConforme;
    private Integer iNumMisRequerimientosCerradosRechazados;
    private Integer iNumMisRequerimientosCerradosAnulados;
    private Integer iNumMisRequerimientosNoConformes;
    private Integer iNumMisRequerimientosCerradosPorRevesion;
}
