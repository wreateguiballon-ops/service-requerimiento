package pe.gob.sat.servicio.requerimiento.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@Builder
@NoArgsConstructor  // Necesario para deserialización y frameworks
@AllArgsConstructor
public class RequerimientoDatosResponseDto {
    private List<RequerimientoDato1ResponseDto> detalle;
    private List<RequerimientoDato2ResponseDto> detalle2;
}
