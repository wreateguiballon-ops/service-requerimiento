package pe.gob.sat.servicio.general.repository;

import jakarta.persistence.Tuple;

import java.util.List;

public interface GeneralRepository {
    List<Tuple> ConsultarDatosTablas(String cTipPar, String vXmlGR);
}
