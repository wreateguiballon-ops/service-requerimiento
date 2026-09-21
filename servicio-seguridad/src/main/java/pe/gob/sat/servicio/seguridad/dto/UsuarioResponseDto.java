package pe.gob.sat.servicio.seguridad.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioResponseDto {
    private Integer iCodigo_Per;
    private String cCodPer;
    private String vUsuWin;
    private String vNumDni;
    private String vNombre;
    private String vApePat;
    private String vApeMat;
    private Integer nCodUo;
    private String vDesLuo;
    private Integer nCodCar;
    private String vDesCar;
    private String vNomEst;
    private String vNomCat;
    private String vCorreo;
    private Integer siCodigoRol;
    private String vNombreRol;
    private Integer iCodigo_PerRol;
    private Integer iCodigo_TipoRol;
    private String vNombre_TipoRol;
    private Integer NumeroRoles;
    private String NombreCompleto;
    private Integer iCodigo_Ing;
}
