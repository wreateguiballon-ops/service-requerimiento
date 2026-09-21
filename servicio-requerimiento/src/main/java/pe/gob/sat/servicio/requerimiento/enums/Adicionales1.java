package pe.gob.sat.servicio.requerimiento.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor

public enum Adicionales1 {
    iCodigo_Req(0),
    sdFecha_Req(1),
    vDescripcion_Req(2),
    iCodigoPadre_Req(3),
    iCodUo(4),
    iCodigo_PerJefeUnidad(5),
    iCodigo_Per(6),
    vApePatSol(7),
    vApeMatSol(8),
    vNombreSol(9),
    siCodCarSol(10),
    vDesCarSol(11),
    vDesLUoSol(12),
    siCodigo_Est(13),
    vNombre_Est(14),
    iCodigo_CSC(15),
    siCodigo_Cat(16),
    vNombre_Cat(17),
    siCodigo_SubCat(18),
    vNombre_SubCat(19),
    vDescripcion_Cla(20),
    iCodigo_TipEva(21),
    iCodigo_TipMod(22),
    iCodigo_TipAut(23),
    iCodigo_ResPrincipal(24),
    iCodigo_PerUnidadSuperior(25),
    iCodigo_PerResponsable(26),
    bUnidadPerteneciente(27),
    SolicitanteAutorizacion(28),
    FechaSolicitudAut(29);

    private final int index;

    public int get(){
        return  index;
    }
}
