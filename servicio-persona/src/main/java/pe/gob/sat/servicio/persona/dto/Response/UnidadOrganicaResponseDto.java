package pe.gob.sat.servicio.persona.dto.Response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UnidadOrganicaResponseDto {
    private Integer iCodigo_Uo;
    private Integer nCodUO;
    private String vDesLUO;
    private String vDesCUO;
    private Integer nNumGru;
    private String cCodPer;
    private String vSupUO;

    private Integer iCodUO;
}
