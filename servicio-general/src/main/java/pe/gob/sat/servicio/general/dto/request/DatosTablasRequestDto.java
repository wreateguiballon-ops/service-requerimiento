package pe.gob.sat.servicio.general.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static pe.gob.sat.common.util.DataMapperUtils.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DatosTablasRequestDto {
    @NotNull(message = "El tipo de parametro (cTipPar) es obligatorio.")
    private String cTipPar;
    private String vXmlGR;
}
