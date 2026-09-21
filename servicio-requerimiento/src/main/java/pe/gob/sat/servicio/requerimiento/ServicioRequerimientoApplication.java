package pe.gob.sat.servicio.requerimiento;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {
        "pe.gob.sat.servicio.requerimiento",
        "pe.gob.sat.common" // Escanea el manejador global del common
})
public class ServicioRequerimientoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServicioRequerimientoApplication.class, args);
    }

}
