package pe.gob.sat.servicio.requerimiento.service;

import pe.gob.sat.servicio.requerimiento.dto.RequerimientoConsultarRequestDto;
import pe.gob.sat.servicio.requerimiento.dto.RequerimientoRegistrarRequestDto;
import pe.gob.sat.servicio.requerimiento.dto.request.DocumentoAdjuntoRequestDto;
import pe.gob.sat.servicio.requerimiento.dto.response.DocumentoAdjuntoResponseDto;

import java.util.List;

public interface RequerimientoService {
    List<?> consultarRequerimiento(RequerimientoConsultarRequestDto request);
    void registrarRequerimiento(RequerimientoRegistrarRequestDto request);
    List<DocumentoAdjuntoResponseDto> ConsultarDocumentoAdjunto(DocumentoAdjuntoRequestDto request);
}
