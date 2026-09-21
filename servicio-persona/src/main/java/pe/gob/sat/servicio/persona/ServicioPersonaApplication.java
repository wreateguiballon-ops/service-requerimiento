package pe.gob.sat.servicio.persona;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication

@ComponentScan(basePackages = {
		"pe.gob.sat.servicio.persona", // Su propio paquete
		"pe.gob.sat.common"            // El paquete de la librería
})
public class ServicioPersonaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicioPersonaApplication.class, args);
	}

}
