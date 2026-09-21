package pe.gob.sat.servicio.requerimiento.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequerimientoAdicionales1ResponseDto {
    private Integer iCodigo_Req;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime sdFecha_Req;
    private String vDescripcion_Req;
    private Integer iCodigoPadre_Req;
    private Integer iCodUo;
    private Integer iCodigo_PerJefeUnidad;
    private Integer iCodigo_Per;
    private String vApePatSol;
    private String vApeMatSol;
    private String vNombreSol;
    private Integer siCodCarSol;
    private String vDesCarSol;
    private String vDesLUoSol;
    private Integer siCodigo_Est;
    private String vNombre_Est;
    private Integer iCodigo_CSC;
    private Integer siCodigo_Cat;
    private String vNombre_Cat;
    private Integer siCodigo_SubCat;
    private String vNombre_SubCat;
    private String vDescripcion_Cla;
    private Integer iCodigo_TipEva;
    private Integer iCodigo_TipMod;
    private Integer iCodigo_TipAut;
    private Integer iCodigo_ResPrincipal;
    private Integer iCodigo_PerUnidadSuperior;
    private Integer iCodigo_PerResponsable;
    private Boolean bUnidadPerteneciente;
    private String SolicitanteAutorizacion;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime FechaSolicitudAut;

}
