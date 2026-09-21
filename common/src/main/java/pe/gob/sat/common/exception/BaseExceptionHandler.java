package pe.gob.sat.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class BaseExceptionHandler {

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<Map<String, Object>> handleResponseStatusException(ResponseStatusException ex) {
        Map<String, Object> errorDetails = new HashMap<>();
        errorDetails.put("timestamp", LocalDateTime.now());
        errorDetails.put("status", ex.getStatusCode().value());
        errorDetails.put("error", ex.getReason());
        errorDetails.put("message", ex.getReason());

        return ResponseEntity.status(ex.getStatusCode()).body(errorDetails);
    }

    // Puedes agregar más manejadores genéricos (Exception.class) aquí
}