package pe.gob.sat.servicio.persona.dto.Request;

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
public class PersonaRequestDto {
    @NotNull(message = "El tipo de búsqueda (siTipBus) es obligatorio.")
    @Min(value = 1, message = "El tipo de búsqueda (siTipBus) debe ser un valor válido (ej. 1 o 2).")
    private Integer siTipBus;
    private Integer iCodigo_Per;
    private Integer iCodUo;
    private String cCodPer;
    private String vApePat;
    private Integer pTipo;

    public String toXmlParam() {
        StringBuilder sb = new StringBuilder("<R><XmlGR");
        appendIfNotNull(sb, "siTipBus", this.siTipBus);
        appendIfNotNull(sb, "iCodigo_Per", this.iCodigo_Per);
        appendIfNotNull(sb, "iCodUo", this.iCodUo);
        appendIfNotNull(sb, "cCodPer", this.cCodPer);
        appendIfNotNull(sb, "vApePat", this.vApePat);
        appendIfNotNull(sb, "pTipo", this.pTipo);
        sb.append(" /></R>");
        return sb.toString();
    }
}
