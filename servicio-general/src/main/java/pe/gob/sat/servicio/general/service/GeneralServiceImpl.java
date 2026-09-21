package pe.gob.sat.servicio.general.service;

import jakarta.persistence.Tuple;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.gob.sat.servicio.general.dto.request.DatosTablasRequestDto;
import pe.gob.sat.servicio.general.dto.response.DatosTablasResponseDto;
import pe.gob.sat.servicio.general.repository.GeneralRepository;

import java.util.List;

import static pe.gob.sat.common.util.DataMapperUtils.*;


@Service
@RequiredArgsConstructor
public class GeneralServiceImpl implements  GeneralService{
    private final GeneralRepository generalRepository;
    @Override
    @Transactional
    public List<DatosTablasResponseDto> ConsultarDatosTablas(String cTipPar, String vXmlGR) {
        List<Tuple> tabla = generalRepository.ConsultarDatosTablas(cTipPar, vXmlGR);
        if (tabla == null || tabla.isEmpty()){
            return List.of();
        }

        return tabla.stream().map(tuple-> DatosTablasResponseDto.builder()
                .iCodigo_Atr(toInteger(tuple.get("iCodigo_Atr")))
                .cDescripcion_Atr(parseString(tuple.get("cDescripcion_Atr")))
                .build()).toList();
    }
}
