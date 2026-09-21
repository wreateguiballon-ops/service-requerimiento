package pe.gob.sat.servicio.requerimiento.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.gob.sat.servicio.requerimiento.dto.RequerimientoConsultarRequestDto;
import pe.gob.sat.servicio.requerimiento.dto.RequerimientoRegistrarRequestDto;
import pe.gob.sat.servicio.requerimiento.dto.request.DocumentoAdjuntoRequestDto;
import pe.gob.sat.servicio.requerimiento.dto.response.DocumentoAdjuntoResponseDto;
import pe.gob.sat.servicio.requerimiento.service.RequerimientoService;

import java.util.List;

@RestController
@RequestMapping("/api/requerimiento")
@RequiredArgsConstructor
public class RequerimientoController {
    private final RequerimientoService requerimientoService;
    @GetMapping("/consultar")
    public ResponseEntity<List<?>> consultarRequerimiento(@Valid @RequestBody RequerimientoConsultarRequestDto request){
        List<?> respuesta = requerimientoService.consultarRequerimiento(request);
        return ResponseEntity.ok(respuesta);
    }
    @PostMapping("/registrar")
    public ResponseEntity<String> registrarRequerimiento(@Valid @RequestBody RequerimientoRegistrarRequestDto request) {
        requerimientoService.registrarRequerimiento(request);
        return ResponseEntity.ok("Requerimiento registrado o actualizado correctamente.");
    }
    @GetMapping("/DocumentoAdjunto")
    public  ResponseEntity<List<DocumentoAdjuntoResponseDto>> ConsultarDocumentoAdjunto(@Valid @RequestBody DocumentoAdjuntoRequestDto request){
            List<DocumentoAdjuntoResponseDto>  respuesta = requerimientoService.ConsultarDocumentoAdjunto(request);
        return  ResponseEntity.ok(respuesta);
    }
}
