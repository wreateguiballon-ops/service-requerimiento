package pe.gob.sat.servicio.seguridad.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import static pe.gob.sat.servicio.seguridad.util.DataMapperUtils.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioRequestDto {
    /*@NotNull(message = "El tipo de búsqueda (siTipBus) es obligatorio.")
    @Min(value = 1, message = "El tipo de búsqueda (siTipBus) debe ser un valor válido (ej. 1 o 2).")*/
    private Integer siTipBus;

    /*@NotBlank(message = "El usuario Windows (vUsuWin) no puede estar vacío ni ser nulo.")*/
    private String vUsuWin;

   /* @NotNull(message = "El código de rol (siCodigoRol) es obligatorio.")
    @Min(value = 0, message = "El código de rol (siCodigoRol) no puede ser negativo.")*/
    private Integer siCodigoRol;

    private Integer iCodigo_Per; //= "6046"
    private Integer iCodigo_PerRol; // = "20753"
    private String  vCodigoSesion_Ac; //= "m41huk3mxbeorvqnp2b4lbty"
    private Integer cCodPerActualizacion; //= "9509"
    private String cNombreTerminal_Ac;// = "P7A-ASO09"

    public String toXmlParam() {
        StringBuilder sb = new StringBuilder("<R><XmlGR");
        //Login
        appendIfNotNull(sb, "siTipBus", this.siTipBus);
        appendIfNotNull(sb, "vUsuWin", this.vUsuWin);
        appendIfNotNull(sb, "siCodigoRol", this.siCodigoRol);
        //Registrar
        appendIfNotNull(sb, "iCodigo_Per", this.iCodigo_Per);
        appendIfNotNull(sb, "iCodigo_PerRol", this.iCodigo_PerRol);
        appendIfNotNull(sb, "vCodigoSesion_Ac", this.vCodigoSesion_Ac);
        appendIfNotNull(sb, "cCodPerActualizacion", this.cCodPerActualizacion);
        appendIfNotNull(sb, "cNombreTerminal_Ac", this.cNombreTerminal_Ac);
        sb.append(" /></R>");
        return sb.toString();
    }
}
