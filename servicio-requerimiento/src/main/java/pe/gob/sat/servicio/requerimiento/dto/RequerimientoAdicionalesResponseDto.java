package pe.gob.sat.servicio.requerimiento.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequerimientoAdicionalesResponseDto {
    private List<RequerimientoAdicionales1ResponseDto> detalle;
    private List<RequerimientoAdicionales2ResponseDto> detalle2;
}
