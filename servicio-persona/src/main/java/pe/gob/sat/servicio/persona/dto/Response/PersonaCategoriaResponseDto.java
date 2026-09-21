package pe.gob.sat.servicio.persona.dto.Response;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonaCategoriaResponseDto {
    private Integer siTipBus;
    private Integer iCodigo_PerCat;
    private Integer iCodUo;
    private String  cCodPer;
    private Integer siCodigo_Act;
    private Integer siCodigo_Cat;
    private Integer siCodigo_SubCat;
}
