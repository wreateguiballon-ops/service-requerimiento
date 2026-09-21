package pe.gob.sat.servicio.requerimiento.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
@Getter
@AllArgsConstructor
public enum misPendientes {

    iCodigo_Req(0),
    sdFecha_Req(1),
    vDesLUo(2),
    iCodUo(3),
    Responsable(4),
    Prioridad(5),
    TipoEvaluacion(6),
    Estado(7),
    siCodigo_Est(8),
    iCodigo_Per(9),
    vNombre_Cat(10),
    vNombre_SubCat(11);

    private final int index;


    public int get(){
        return  index;
    }
}
