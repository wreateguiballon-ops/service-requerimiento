package pe.gob.sat.servicio.seguridad.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.Tuple;
import org.springframework.stereotype.Repository;
import pe.gob.sat.servicio.seguridad.service.UsuarioService;

import java.util.List;

@Repository
public class UsuarioRepositoryImpl implements UsuarioRepository {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Tuple> consultarUsuario(String xmlParam) {
        Query query = entityManager.createNativeQuery(
                "EXEC dbo.spGR_Seguridad_ConsultarUsuario :xmlParam",Tuple.class);
        query.setParameter("xmlParam", xmlParam);

        @SuppressWarnings("unchecked")
        List<Tuple> tabla = query.getResultList();

        return tabla != null ? tabla : List.of();
    }

    public List<Tuple> RegistrarInicioSesion(String xmlParam){
        Query query = entityManager.createNativeQuery("EXEC spGR_Seguridad_RegistrarInicioSesion :xmlParam", Tuple.class);
        query.setParameter("xmlParam", xmlParam);
        List<Tuple> tabla = query.getResultList();

        return tabla != null ? tabla : List.of();
    }
}
