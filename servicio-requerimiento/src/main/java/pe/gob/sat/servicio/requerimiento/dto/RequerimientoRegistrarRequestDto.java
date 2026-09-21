package pe.gob.sat.servicio.requerimiento.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import static pe.gob.sat.common.util.DataMapperUtils.*;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequerimientoRegistrarRequestDto {

    @NotNull(message = "El tipo de búsqueda (siTipBus) es obligatorio.")
    @Min(value = 1, message = "El tipo de búsqueda (siTipBus) debe ser un valor válido.")
    private Integer siTipBus;

    private String vSql;
    private Integer iCodigo_Req;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime sdFecha_Req;

    private String vDescripcion_Req;
    private String vSumilla_Req;
    private Integer iCodigoPadre_Req;
    private Integer iCodigo_Uo;
    private Integer iCodigo_Per;
    private Integer siCodigo_Est;
    private Integer iCodigo_CSC;
    private Integer iCodigo_Pri;
    private Integer iCodigo_TipEva;
    private Integer iCodigo_TipEnv;
    private Integer iCodigo_TipDocSus;
    private String cNumero_DocSus;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime sdFecha_DocSus;

    private String vDocumentoAdjunto_Req;
    private String vObservacion_Req;
    private Boolean bAvance_Req;
    private Boolean bFisico_Req;

    private String vDatCom;

    private String vCodInv;
    private Boolean bVigencia_Req;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime sdFechaCierre_Req;

    private Boolean bHabilitacion_Req;
    private Boolean bMigracion_Req;
    private Boolean bActivo_Req;
    private String cCodPerActualizacion;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime sdFechaActualizacion_Req;

    private String cNombreTerminal_Req;

    private String vCorreosCopia;
    private String vParametros;
    private Integer iCodigo_TipOpe;
    private Integer iCodDivRes;
    private Integer siCodigo_Act;
    private Integer siCodigo_Cat;
    private Integer siCodigo_SubCat;
    private Boolean bActivo_CSC;
    private String cFecha_DocSus;

    private Integer siTipOpe;
    private String cCodPer;
    private Boolean bActivo_Per;
    private Integer iCodigo_PerDes_ReqMov;
    private String vObservacion_ReqMov;
    private Integer iCodigo_ReqMov;
    private Integer siCodigo_EstMov;
    private Boolean bActivo_ReqMov;
    private Integer iCodUORes;

    private Integer iCodigo_ReqUbi;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime sdFecha_ReqUbi;

    private Integer iCodUoOrigen_ReqUbi;
    private Integer iCodUoDestino_ReqUbi;
    private Boolean bPrincipal_ReqUbi;
    private Boolean bActivo_ReqUbi;
    private Integer iCodUO;
    private Integer iCodUoOri_ReqMov;
    private Integer iCodUoDes_ReqMov;
    private Boolean bResPrincipal_ReqMov;
    private Boolean bInformeTecnico_ReqMov;
    private Integer iCodigo_TipNoCon;
    private Boolean bActivo;

    /**
     * Construye el XML dinámicamente con todos los atributos que no sean nulos,
     * aplicando escape de XML a las cadenas de texto y formateando fechas.
     */
    public String toXmlParam() {
        StringBuilder sb = new StringBuilder("<R><XmlGR");

        appendIfNotNull(sb, "siTipBus", this.siTipBus);
        appendIfNotNull(sb, "vSql", this.vSql);
        appendIfNotNull(sb, "iCodigo_Req", this.iCodigo_Req);
        appendIfNotNull(sb, "sdFecha_Req", this.sdFecha_Req);
        appendIfNotNull(sb, "vDescripcion_Req", this.vDescripcion_Req);
        appendIfNotNull(sb, "vSumilla_Req", this.vSumilla_Req);
        appendIfNotNull(sb, "iCodigoPadre_Req", this.iCodigoPadre_Req);
        appendIfNotNull(sb, "iCodigo_Uo", this.iCodigo_Uo);
        appendIfNotNull(sb, "iCodigo_Per", this.iCodigo_Per);
        appendIfNotNull(sb, "siCodigo_Est", this.siCodigo_Est);
        appendIfNotNull(sb, "iCodigo_CSC", this.iCodigo_CSC);
        appendIfNotNull(sb, "iCodigo_Pri", this.iCodigo_Pri);
        appendIfNotNull(sb, "iCodigo_TipEva", this.iCodigo_TipEva);
        appendIfNotNull(sb, "iCodigo_TipEnv", this.iCodigo_TipEnv);
        appendIfNotNull(sb, "iCodigo_TipDocSus", this.iCodigo_TipDocSus);
        appendIfNotNull(sb, "cNumero_DocSus", this.cNumero_DocSus);
        appendIfNotNull(sb, "sdFecha_DocSus", this.sdFecha_DocSus);
        appendIfNotNull(sb, "vDocumentoAdjunto_Req", this.vDocumentoAdjunto_Req);
        appendIfNotNull(sb, "vObservacion_Req", this.vObservacion_Req);
        appendIfNotNull(sb, "bAvance_Req", this.bAvance_Req);
        appendIfNotNull(sb, "bFisico_Req", this.bFisico_Req);
        appendIfNotNull(sb, "vDatCom", this.vDatCom);
        appendIfNotNull(sb, "vCodInv", this.vCodInv);
        appendIfNotNull(sb, "bVigencia_Req", this.bVigencia_Req);
        appendIfNotNull(sb, "sdFechaCierre_Req", this.sdFechaCierre_Req);
        appendIfNotNull(sb, "bHabilitacion_Req", this.bHabilitacion_Req);
        appendIfNotNull(sb, "bMigracion_Req", this.bMigracion_Req);
        appendIfNotNull(sb, "bActivo_Req", this.bActivo_Req);
        appendIfNotNull(sb, "cCodPerActualizacion", this.cCodPerActualizacion);
        appendIfNotNull(sb, "sdFechaActualizacion_Req", this.sdFechaActualizacion_Req);
        appendIfNotNull(sb, "cNombreTerminal_Req", this.cNombreTerminal_Req);
        appendIfNotNull(sb, "vCorreosCopia", this.vCorreosCopia);
        appendIfNotNull(sb, "vParametros", this.vParametros);
        appendIfNotNull(sb, "iCodigo_TipOpe", this.iCodigo_TipOpe);
        appendIfNotNull(sb, "iCodDivRes", this.iCodDivRes);
        appendIfNotNull(sb, "siCodigo_Act", this.siCodigo_Act);
        appendIfNotNull(sb, "siCodigo_Cat", this.siCodigo_Cat);
        appendIfNotNull(sb, "siCodigo_SubCat", this.siCodigo_SubCat);
        appendIfNotNull(sb, "bActivo_CSC", this.bActivo_CSC);
        appendIfNotNull(sb, "cFecha_DocSus", this.cFecha_DocSus);
        appendIfNotNull(sb, "siTipOpe", this.siTipOpe);
        appendIfNotNull(sb, "cCodPer", this.cCodPer);
        appendIfNotNull(sb, "bActivo_Per", this.bActivo_Per);
        appendIfNotNull(sb, "iCodigo_PerDes_ReqMov", this.iCodigo_PerDes_ReqMov);
        appendIfNotNull(sb, "vObservacion_ReqMov", this.vObservacion_ReqMov);
        appendIfNotNull(sb, "iCodigo_ReqMov", this.iCodigo_ReqMov);
        appendIfNotNull(sb, "siCodigo_EstMov", this.siCodigo_EstMov);
        appendIfNotNull(sb, "bActivo_ReqMov", this.bActivo_ReqMov);
        appendIfNotNull(sb, "iCodUORes", this.iCodUORes);
        appendIfNotNull(sb, "iCodigo_ReqUbi", this.iCodigo_ReqUbi);
        appendIfNotNull(sb, "sdFecha_ReqUbi", this.sdFecha_ReqUbi);
        appendIfNotNull(sb, "iCodUoOrigen_ReqUbi", this.iCodUoOrigen_ReqUbi);
        appendIfNotNull(sb, "iCodUoDestino_ReqUbi", this.iCodUoDestino_ReqUbi);
        appendIfNotNull(sb, "bPrincipal_ReqUbi", this.bPrincipal_ReqUbi);
        appendIfNotNull(sb, "bActivo_ReqUbi", this.bActivo_ReqUbi);
        appendIfNotNull(sb, "iCodUO", this.iCodUO);
        appendIfNotNull(sb, "iCodUoOri_ReqMov", this.iCodUoOri_ReqMov);
        appendIfNotNull(sb, "iCodUoDes_ReqMov", this.iCodUoDes_ReqMov);
        appendIfNotNull(sb, "bResPrincipal_ReqMov", this.bResPrincipal_ReqMov);
        appendIfNotNull(sb, "bInformeTecnico_ReqMov", this.bInformeTecnico_ReqMov);
        appendIfNotNull(sb, "iCodigo_TipNoCon", this.iCodigo_TipNoCon);
        appendIfNotNull(sb, "bActivo", this.bActivo);

        sb.append(" /></R>");
        return sb.toString();
    }


}