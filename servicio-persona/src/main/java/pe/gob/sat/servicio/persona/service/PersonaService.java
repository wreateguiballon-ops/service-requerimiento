package pe.gob.sat.servicio.persona.service;

import jakarta.persistence.Tuple;
import pe.gob.sat.servicio.persona.dto.Request.PersonaRequestDto;
import pe.gob.sat.servicio.persona.dto.Request.UnidadOrganicaRequestDto;
import pe.gob.sat.servicio.persona.dto.Response.PersonaResponseDto;
import pe.gob.sat.servicio.persona.dto.Response.UnidadOrganicaResponseDto;

import java.util.List;

public interface PersonaService {
    List<PersonaResponseDto> Consultar(PersonaRequestDto request);
    List<UnidadOrganicaResponseDto> ConsultarUnidadOrganica(UnidadOrganicaRequestDto request);
}
