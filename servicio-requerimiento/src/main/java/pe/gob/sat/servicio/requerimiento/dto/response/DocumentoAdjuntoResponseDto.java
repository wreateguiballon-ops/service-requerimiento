package pe.gob.sat.servicio.requerimiento.dto.response;

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
public class DocumentoAdjuntoResponseDto {
    private Integer iNumCor;
    private Integer iCodigo_DocAdj;
    private Integer iCodigo_Req;
    private String TipoAdjunto;
    private String vNombre_DocAdj;
    private String vNombreOriginal_DocAdj;
    private String vDescripcion_DocAdj;
    private Short siEjecucion_DocAdj;
    private String Usuario;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime sdFechaCarga_DocAdj;
    private String cNombreTerminal_DocAdj;
    private Integer iCodigo_TipAdj;
    private Integer iCodigo_PerCar_DocAdj;
}
