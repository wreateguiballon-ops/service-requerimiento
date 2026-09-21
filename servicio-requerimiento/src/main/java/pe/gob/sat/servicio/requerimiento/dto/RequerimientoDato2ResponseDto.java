package pe.gob.sat.servicio.requerimiento.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequerimientoDato2ResponseDto {
    private String vUsuWin;
    private String vNombre;
    private String vDesCar;
}
