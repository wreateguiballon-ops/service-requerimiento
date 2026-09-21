package pe.gob.sat.servicio.seguridad.service;

import pe.gob.sat.servicio.seguridad.dto.UsuarioRequestDto;
import pe.gob.sat.servicio.seguridad.dto.UsuarioResponseDto;

import java.util.List;

public interface UsuarioService {
    List<UsuarioResponseDto> consultarUsuario(UsuarioRequestDto request);
    List<UsuarioResponseDto> RegistrarInicioSesion(UsuarioRequestDto request);
}