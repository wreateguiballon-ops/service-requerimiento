package pe.gob.sat.servicio.requerimiento.repository;

import jakarta.persistence.*;
import org.springframework.stereotype.Repository;
import pe.gob.sat.servicio.requerimiento.dto.RequerimientoRegistrarRequestDto;
import pe.gob.sat.servicio.requerimiento.repository.RequerimientoRepository;
import pe.gob.sat.servicio.requerimiento.enums.*; // o la clase específica

import java.util.List;
import java.util.Map;

@Repository
public class RequerimientoRepositoryImpl implements  RequerimientoRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @SuppressWarnings("unchecked")
    public Map<String, List<Object[]>> consultarRequerimiento(String xmlParam) {
        // 1. Crear la consulta SIN el parámetro Tuple.class
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("dbo.spGR_Requerimiento_Consultar");

        query.registerStoredProcedureParameter("ptXmlGR", String.class, ParameterMode.IN);
        query.setParameter("ptXmlGR", xmlParam);

        boolean hasResults = query.execute();

        // 2. Hibernate devolverá los resultsets como List<Object[]> de forma nativa
        List<Object[]> tabla1 = hasResults ? (List<Object[]>) query.getResultList() : List.of();
        List<Object[]> tabla2 = query.hasMoreResults() ? (List<Object[]>) query.getResultList() : List.of();

        return Map.of(
                "tabla1", tabla1,
                "tabla2", tabla2
        );
    }
    @Override
    public void registrarRequerimiento(RequerimientoRegistrarRequestDto request) {
        // Nombre de tu Stored Procedure en SQL Server para el registro
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("spGR_Requerimiento_Registrar");

        // Registramos el parámetro XML que espera el procedimiento
        query.registerStoredProcedureParameter("vParametros", String.class, ParameterMode.IN);

        // Invocamos el método del DTO para obtener el XML generado de forma dinámica
        query.setParameter("vParametros", request.toXmlParam());

        // Ejecutamos la consulta
        query.execute();
    }

    @Override
    public List<Tuple> ConsultarDocumentoAdjunto(String xmlParam) {
        Query query = entityManager.createNativeQuery("Exec spGR_Requerimiento_ConsultarDocumentoAdjunto :xmlParam", Tuple.class);
        query.setParameter("xmlParam",xmlParam);
        @SuppressWarnings("unchecked")
        List<Tuple> resultados = query.getResultList();

        return resultados != null  ? resultados : List.of();
    }
}
