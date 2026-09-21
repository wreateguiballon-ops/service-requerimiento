package pe.gob.sat.servicio.persona.dto.Response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonaResponseDto {
    private String  cCodPer;
    private String vNombre;
    private Integer iCodigo_Per;
    private String vUsuWin;
    private Boolean bVigencia_Per;
    private String Vigencia_Per;
    private String vDesLUo;
    private String vObservacion_Per;
    private Integer iCodUo;
}
