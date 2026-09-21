package pe.gob.sat.servicio.seguridad.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import pe.gob.sat.servicio.seguridad.config.JwtToken;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.gob.sat.servicio.seguridad.dto.UsuarioRequestDto;
import pe.gob.sat.servicio.seguridad.dto.UsuarioResponseDto;
import pe.gob.sat.servicio.seguridad.service.UsuarioService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UsuarioService usuarioService;
    private final JwtToken jwtTokenUtil; // <-- Debe ser final para que Lombok lo inyecte correctamente

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody UsuarioRequestDto request){
        //System.out.println("Inicio del Controlador auth/login");

        List<UsuarioResponseDto> respuesta = usuarioService.consultarUsuario(request);

        if (respuesta != null && !respuesta.isEmpty()) {
            UsuarioResponseDto usuario = respuesta.get(0);
            String username = request.getVUsuWin();
            String token = jwtTokenUtil.generateToken(username);

            return ResponseEntity.ok(Map.of(
                    "token", token,
                    "expiresAt", jwtTokenUtil.getExpirationInstant(token).toString(),
                    "NumeroRoles", usuario.getNumeroRoles(),
                    "ICodigo_Per",usuario.getICodigo_Per(),
                    "NombreCompleto", usuario.getNombreCompleto(),
                    "CCodPer", usuario.getCCodPer()
            ));
        } else {
            return ResponseEntity.status(401).body(Map.of("error", "Usted no está autorizado"));
        }
    }
}