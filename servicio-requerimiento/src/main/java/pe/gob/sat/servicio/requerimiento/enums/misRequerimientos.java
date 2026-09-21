package pe.gob.sat.servicio.requerimiento.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
@Getter
@AllArgsConstructor
public enum misRequerimientos {
    iCodigo_Req(0),
    sdFecha_Req(1),
    vDesLUo(2),
    iCodUo(3),
    Solicitante(4),
    Categoria(5),
    SubCategoria(6),
    Prioridad(7),
    Estado(8),
    TipoEvaluacion(9),
    siCodigo_Est(10),
    iCodigo_Per(11);

    private final int index;


    public int get() {
        return index;
    }
}
