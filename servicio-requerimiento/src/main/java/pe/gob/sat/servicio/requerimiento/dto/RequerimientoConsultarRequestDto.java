package pe.gob.sat.servicio.requerimiento.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static pe.gob.sat.common.util.DataMapperUtils.appendIfNotNull;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequerimientoConsultarRequestDto {
    @NotNull(message = "El tipo de búsqueda (siTipBus) es obligatorio.")
    @Min(value = 1, message = "El tipo de búsqueda (siTipBus) debe ser un valor válido (ej. 1 o 2).")
    private Integer siTipBus;
    private Integer siCodigo_Rol;
    private Integer iCodigo_Per;
    private Integer siCodigoFiltro;
    private Integer iCodigo_Req;

    public String toXmlParam() {
        StringBuilder sb = new StringBuilder("<R><XmlGR");
        appendIfNotNull(sb, "siTipBus", this.siTipBus);
        appendIfNotNull(sb, "siCodigo_Rol", this.siCodigo_Rol);
        appendIfNotNull(sb, "iCodigo_Per", this.iCodigo_Per);
        appendIfNotNull(sb, "siCodigoFiltro", this.siCodigoFiltro);
        appendIfNotNull(sb, "iCodigo_Req", this.iCodigo_Req);
        sb.append(" /></R>");
        return sb.toString();
    }

}




