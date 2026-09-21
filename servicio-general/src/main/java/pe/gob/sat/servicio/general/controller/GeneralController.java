package pe.gob.sat.servicio.general.controller;

import jakarta.validation.Valid;
import org.hibernate.validator.constraintvalidators.RegexpURLValidator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.gob.sat.servicio.general.dto.request.DatosTablasRequestDto;
import pe.gob.sat.servicio.general.dto.response.DatosTablasResponseDto;
import pe.gob.sat.servicio.general.service.GeneralService;

import java.util.List;


@RestController
@RequestMapping("/api/general")
public class GeneralController {
    private final GeneralService generalService;

    public GeneralController(GeneralService generalService){
        this.generalService = generalService;
    }
    @GetMapping("/ConsultarDatosTablas")
    public ResponseEntity<List<DatosTablasResponseDto>> ConsultarDatosTablas(@Valid @RequestBody DatosTablasRequestDto request){
        List<DatosTablasResponseDto> tabla = generalService.ConsultarDatosTablas(request.getCTipPar(), request.getVXmlGR());
        return ResponseEntity.ok(tabla);
    }
}
