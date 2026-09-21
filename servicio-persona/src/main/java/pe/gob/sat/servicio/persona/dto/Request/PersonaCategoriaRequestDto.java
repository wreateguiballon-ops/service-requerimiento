package pe.gob.sat.servicio.persona.dto.Request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static pe.gob.sat.common.util.DataMapperUtils.appendIfNotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonaCategoriaRequestDto {
    private Integer siTipBus;
    private Integer iCodigo_PerCat;
    private Integer iCodUo;
    private String cCodPer;
    private Integer siCodigo_Act;
    private Integer siCodigo_Cat;
    private Integer siCodigo_SubCat;

    public String toXml(){
        StringBuilder sb = new StringBuilder("<R><XmlGR");
        appendIfNotNull(sb, "siTipBus", this.siTipBus);
        appendIfNotNull(sb, "iCodigo_PerCat", this.iCodigo_PerCat);
        appendIfNotNull(sb, "iCodUo", this.iCodUo);
        appendIfNotNull(sb, "cCodPer", this.cCodPer);
        appendIfNotNull(sb, "siCodigo_Act", this.siCodigo_Act);
        appendIfNotNull(sb, "siCodigo_Cat", this.siCodigo_Cat);
        appendIfNotNull(sb, "siCodigo_SubCat", this.siCodigo_SubCat);
        sb.append(" /></R>");
        return sb.toString();
    }
}
