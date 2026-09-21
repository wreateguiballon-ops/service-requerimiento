package pe.gob.sat.servicio.general.service;

import pe.gob.sat.servicio.general.dto.request.DatosTablasRequestDto;
import pe.gob.sat.servicio.general.dto.response.DatosTablasResponseDto;
import pe.gob.sat.servicio.general.repository.GeneralRepository;

import java.util.List;

public interface GeneralService {
    List<DatosTablasResponseDto> ConsultarDatosTablas(String cTipPar, String vXmlGR);
}
