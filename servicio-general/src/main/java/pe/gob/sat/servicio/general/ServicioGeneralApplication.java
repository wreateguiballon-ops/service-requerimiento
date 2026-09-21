package pe.gob.sat.servicio.general;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import pe.gob.sat.common.secutiry.SecurityConfig;

@SpringBootApplication
@ComponentScan(basePackages = {
		"pe.gob.sat.servicio.general", // Su propio paquete
		"pe.gob.sat.common"            // El paquete de la librería
})
@Import(SecurityConfig.class)
public class ServicioGeneralApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicioGeneralApplication.class, args);
	}

}
