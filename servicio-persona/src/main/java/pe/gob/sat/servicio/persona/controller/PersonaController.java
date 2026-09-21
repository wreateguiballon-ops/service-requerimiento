package pe.gob.sat.servicio.persona.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.gob.sat.servicio.persona.dto.Request.PersonaRequestDto;
import pe.gob.sat.servicio.persona.dto.Response.PersonaResponseDto;
import pe.gob.sat.servicio.persona.dto.Response.UnidadOrganicaResponseDto;
import pe.gob.sat.servicio.persona.dto.Request.UnidadOrganicaRequestDto;
import pe.gob.sat.servicio.persona.service.PersonaService;

import java.util.List;

@RestController
@RequestMapping("/api/persona")
public class PersonaController {
    private final PersonaService personaService;

    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }

    @PostMapping("/consultar")
    public ResponseEntity<List<PersonaResponseDto>> Consultar(@Valid @RequestBody PersonaRequestDto request){
        List<PersonaResponseDto> tabla = personaService.Consultar(request);
        return ResponseEntity.ok(tabla);
    }
    @GetMapping("/consultarUnidadOrganica")
    public ResponseEntity<List<UnidadOrganicaResponseDto>> ConsultarUnidadOrganica(@Valid @RequestBody UnidadOrganicaRequestDto request){
        List<UnidadOrganicaResponseDto> tabla = personaService.ConsultarUnidadOrganica(request);
        return ResponseEntity.ok(tabla);
    }
}
