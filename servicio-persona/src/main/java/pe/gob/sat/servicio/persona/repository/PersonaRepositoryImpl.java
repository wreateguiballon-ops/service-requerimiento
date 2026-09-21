package pe.gob.sat.servicio.persona.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.Tuple;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonaRepositoryImpl implements PersonaRepository {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Tuple> Consultar(String xmlParam) {
        Query query = entityManager.createNativeQuery("Exec spGR_Persona_Consultar :xmlParam", Tuple.class);
        query.setParameter("xmlParam", xmlParam);
        @SuppressWarnings("unchecked")
        List<Tuple> tabla = query.getResultList();
        return tabla != null ? tabla : List.of();
    }

    @Override
    public List<Tuple> ConsultarUnidadOrganica(String xmlParam) {
        Query query =entityManager.createNativeQuery("Exec spGR_UnidadOrganica_Consultar :xmlParam", Tuple.class);
        query.setParameter("xmlParam", xmlParam);
        @SuppressWarnings("unchecked")
        List<Tuple> tabla = query.getResultList();
        return tabla != null ? tabla : List.of();
    }
}
