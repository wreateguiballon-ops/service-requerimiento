package pe.gob.sat.servicio.requerimiento.repository;

import jakarta.persistence.Tuple;
import pe.gob.sat.servicio.requerimiento.dto.RequerimientoRegistrarRequestDto;

import java.util.List;
import java.util.Map;


public interface RequerimientoRepository {
    Map<String, List<Object[]>> consultarRequerimiento(String xmlParam);
    void registrarRequerimiento(RequerimientoRegistrarRequestDto request);
    List<Tuple> ConsultarDocumentoAdjunto(String xmlParm);
    }
