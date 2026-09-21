package pe.gob.sat.servicio.persona.service;

import jakarta.persistence.Tuple;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pe.gob.sat.servicio.persona.dto.Request.PersonaRequestDto;
import pe.gob.sat.servicio.persona.dto.Request.UnidadOrganicaRequestDto;
import pe.gob.sat.servicio.persona.dto.Response.PersonaResponseDto;
import pe.gob.sat.servicio.persona.dto.Response.UnidadOrganicaResponseDto;
import pe.gob.sat.servicio.persona.repository.PersonaRepository;
import static pe.gob.sat.common.util.DataMapperUtils.*;
import java.util.List;



@Service
@RequiredArgsConstructor
public class PersonaServiceImpl implements PersonaService {
    private final PersonaRepository personaRepository;

    @Override
    @Transactional
    public List<PersonaResponseDto> Consultar(PersonaRequestDto request) {
         int tipBus = request.getSiTipBus() != null ? request.getSiTipBus() : 0;
         String xmlParam =  request.toXmlParam();
         List<Tuple> tabla = personaRepository.Consultar(xmlParam);

         if (tabla == null || tabla.isEmpty()){
             return  List.of();
         }
        return switch (tipBus){
            case 1 -> tabla.stream().map(tuple -> PersonaResponseDto.builder()
                        .iCodigo_Per(tuple.get("iCodigo_Per", Integer.class))
                        .vDesLUo(tuple.get("vDesLUo", String.class))
                        .vNombre(tuple.get("vNombre", String.class))
                        .vObservacion_Per(tuple.get("vObservacion_Per", String.class))
                        .Vigencia_Per(tuple.get("Vigencia_Per", String.class))
                        .iCodUo(tuple.get("iCodUo", Integer.class))
                        .cCodPer(tuple.get("cCodPer", String.class))
                        .bVigencia_Per(tuple.get("bVigencia_Per", Boolean.class))
                        .build()).toList();
            case 2 -> tabla.stream().map(tuple -> PersonaResponseDto.builder()
                        .cCodPer(tuple.get("cCodPer", String.class))
                        .vNombre(tuple.get("vNombre", String.class))
                        .iCodigo_Per(tuple.get("iCodigo_Per", Integer.class))
                        .vUsuWin(tuple.get("vUsuWin", String.class))
                        .build()).toList();
            case 3 -> tabla.stream().map(tuple -> PersonaResponseDto.builder()
                        .cCodPer(tuple.get("cCodPer", String.class))
                        .vNombre(tuple.get("vNombre", String.class))
                        .iCodigo_Per(tuple.get("iCodigo_Per", Integer.class))
                        .vUsuWin(tuple.get("vUsuWin", String.class))
                        .bVigencia_Per(tuple.get("bVigencia_Per", Boolean.class))
                    .build()).toList();
            /*case 4 -> tabla.stream().map(tuple -> PersonaResponseDto.builder()
                    .cCodPer(tuple.get("cCodPer", String.class))
                    .build()).toList();*/
            case 5 -> tabla.stream().map(tuple -> PersonaResponseDto.builder()
                    .vUsuWin(tuple.get("vUsuWin", String.class))
                    .vNombre(tuple.get("vNombre", String.class))
                    .build()).toList();
            default -> throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Tipo de búsqueda no soportado: " + tipBus
            );
        };

    }

    @Override
    public List<UnidadOrganicaResponseDto> ConsultarUnidadOrganica(UnidadOrganicaRequestDto request) {
        int tipBus = request.getSiTipBus() != null ? request.getSiTipBus() : 0;
        String xmlParam = request.toXmlParam();
        List<Tuple> tabla = personaRepository.ConsultarUnidadOrganica(xmlParam);
        if (tabla == null || tabla.isEmpty()){
            return  List.of();
        }
        return switch (tipBus){
            case 1 -> tabla.stream().map(tuple -> UnidadOrganicaResponseDto.builder()
                    .iCodigo_Uo(toInteger(tuple.get("iCodigo_Uo")))
                    .iCodUO(toInteger(tuple.get("iCodUO")))
                    .vDesLUO(parseString(tuple.get("vDesLUO")))
                    .nNumGru(toInteger(tuple.get("nNumGru")))
                    .cCodPer(parseString(tuple.get("cCodPer")))
                    .vSupUO(parseString(tuple.get("vSupUO")))
                    .build()).toList();
            case 3 -> tabla.stream().map(tuple -> UnidadOrganicaResponseDto.builder()
                    .nCodUO(toInteger(tuple.get("nCodUO")))
                    .vDesLUO(parseString(tuple.get("vDesLUO")))
                    .vDesCUO(parseString(tuple.get("vDesCUO")))
                    .nNumGru(toInteger(tuple.get("nNumGru")))
                    .cCodPer(parseString(tuple.get("cCodPer")))
                    .vSupUO(parseString(tuple.get("vSupUO")))
                    .build()).toList();
            case 4 -> tabla.stream().map(tuple -> UnidadOrganicaResponseDto.builder()
                    .iCodUO(toInteger(tuple.get("iCodUO")))
                    .vDesLUO(parseString(tuple.get("vDesLUO")))
                    .nNumGru(toInteger(tuple.get("nNumGru")))
                    .cCodPer(parseString(tuple.get("cCodPer")))
                    .vSupUO(parseString(tuple.get("vSupUO")))

                    .build()).toList();
            default -> throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Tipo de búsqueda no soportado: " + tipBus
            );

        };
    }
}
