package pe.gob.sat.servicio.general.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.Tuple;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class GeneralRepositoryImpl implements GeneralRepository{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Tuple> ConsultarDatosTablas(String cTipPar, String vXmlGR) {
        Query query = entityManager.createNativeQuery("Exec spGR_General_ConsultarDatosTablas @pcTipPar = :pcTipPar, @pvXmlGR = :pvXmlGR", Tuple.class);
        query.setParameter("pcTipPar", cTipPar);
        query.setParameter("pvXmlGR", vXmlGR != null ? vXmlGR : "");
        @SuppressWarnings("unchecked")
        List<Tuple> tabla = query.getResultList();
        return tabla != null ? tabla : List.of();
    }
}
