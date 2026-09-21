package pe.gob.sat.servicio.seguridad.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.Tuple;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface UsuarioRepository {
    List<Tuple> consultarUsuario(String xmlParam);

    List<Tuple> RegistrarInicioSesion (String xmlParam);

}