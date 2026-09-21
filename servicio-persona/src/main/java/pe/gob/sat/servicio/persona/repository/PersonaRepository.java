package pe.gob.sat.servicio.persona.repository;

import jakarta.persistence.Tuple;

import java.util.List;

public interface PersonaRepository {
    List<Tuple> Consultar(String xmlParam);
    List<Tuple> ConsultarUnidadOrganica(String xmlParam);
}
