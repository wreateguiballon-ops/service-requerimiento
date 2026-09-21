package pe.gob.sat.servicio.seguridad.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.gob.sat.servicio.seguridad.dto.UsuarioRequestDto;
import pe.gob.sat.servicio.seguridad.dto.UsuarioResponseDto;
import pe.gob.sat.servicio.seguridad.service.UsuarioService;

import java.util.List;

@RestController
@RequestMapping("/api/seguridad")
@RequiredArgsConstructor
public class UsuarioController {
    private final UsuarioService usuarioService;
    @GetMapping("/consultarUsuario")
    public ResponseEntity<List<UsuarioResponseDto>> consultarUsuario(@Valid @RequestBody UsuarioRequestDto request) {
        List<UsuarioResponseDto> tabla = usuarioService.consultarUsuario(request);
        return ResponseEntity.ok(tabla);
    }

    @PostMapping("/registrarInicioSesion")
    public  ResponseEntity<List<UsuarioResponseDto>> registrarInicioSesion(@Valid @RequestBody UsuarioRequestDto request){
        List<UsuarioResponseDto> tabla = usuarioService.RegistrarInicioSesion(request);
        return  ResponseEntity.ok(tabla);
    }
}