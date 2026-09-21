package pe.gob.sat.servicio.requerimiento.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequerimientoMisRequerimientosResponseDto {
    private Integer iCodigo_Req;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime sdFecha_Req;
    private String vDesLUo;
    private Integer iCodUo;
    private String Solicitante;
    private String Categoria;
    private String SubCategoria;
    private String Prioridad;
    private String Estado;
    private String TipoEvaluacion;
    private Integer siCodigo_Est;
    private Integer iCodigo_Per;
}
