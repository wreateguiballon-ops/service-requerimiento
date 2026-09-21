package pe.gob.sat.servicio.general.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DatosTablasResponseDto {
    private Integer iCodigo_Atr;
    private String cDescripcion_Atr;
}
