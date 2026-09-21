package pe.gob.sat.servicio.requerimiento.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequerimientoDato1ResponseDto {
    private Integer iCodigo_Req;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime sdFecha_Req;
    private Integer siCodigo_Est;
    private String vNombre_Est;
    private Integer iCodigo_Pri;
    private String Prioridad;
    private Integer iCodigoPadre_Req;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime sdFechaCierre_Req;
    private Integer iCodigo_Per;
    private Integer iCodUo_Ori;
    private String vDesLUo;
    private String Solicitante;
    private String vDesCar;
    private Integer iCodigo_PerDes_ReqMov;
    private String ResponsableAdministrador;
    private String Responsable;
    private Boolean bResPrincipal_ReqMov;
    private String CargoResponsable;
    private Integer iCodigo_UO;
    private Integer iCodUo;
    private String Ubicacion;
    private Integer iCodigo_TipEva;
    private String TipoEvaluacion;
    private Integer iCodigo_TipEnv;
    private String MedioEnvio;
    private Integer iCodigo_CSC;
    private Integer siCodigo_Cat;
    private String vNombre_Cat;
    private Boolean bInventarioFisico_Cat;
    private Integer siCodigo_SubCat;
    private String vNombre_SubCat;
    private Integer iCodigo_TipDocSus;
    private String DocSustento;
    private String cNumero_DocSus;
    private String TipNoCon;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime sdFecha_DocSus;
    private String vDocumentoAdjunto_Req;
    private String vCodInv;
    private Boolean bAvance_Req;
    private Boolean  bFisico_Req;
    private Integer iCodPer;
    private Integer siCodigo_DId;
    private String vDescripcion_DId;
    private String cDocIde;
    private String cNumDoc;
    private String vDescripcion_Req;
    private String vSumilla_Req;
    private String vObservacion_Req;
    private Integer iCodigo_TipMod;
    private String TipoModificacion;
    private String PriEvalDat;
    private Number nMontoDeuda_EvalDat;
    private Number nMontoPagos_EvalDat;
    private Integer iNumeroRegistros_EvalDat;
    private Integer iNumeroPersonas_EvalDat;
    private String vDescripcion_Cla;
    private String ResponsableAdministrado;
}
