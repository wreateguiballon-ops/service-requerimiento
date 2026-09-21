package pe.gob.sat.servicio.persona.dto.Request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static pe.gob.sat.common.util.DataMapperUtils.appendIfNotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UnidadOrganicaRequestDto {
    private Integer siTipBus;
    private Integer iCodU;
    public  String toXmlParam(){
        StringBuilder sb = new StringBuilder("<R><XmlGR");
        appendIfNotNull(sb, "siTipBus", this.siTipBus);
        appendIfNotNull(sb, "iCodU", this.iCodU);
        sb.append(" /></R>");
        return sb.toString();
    }
}
