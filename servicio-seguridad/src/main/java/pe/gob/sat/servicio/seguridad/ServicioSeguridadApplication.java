package pe.gob.sat.servicio.seguridad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {
		"pe.gob.sat.servicio.seguridad",
		"pe.gob.sat.common.exception" // Escanea el manejador global del common
})
public class ServicioSeguridadApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicioSeguridadApplication.class, args);
	}

}
