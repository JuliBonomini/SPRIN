package ar.com.onready.tuto.repository;

import ar.com.onready.tuto.domain.Provincia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProvinciaRepository extends JpaRepository<Provincia, Integer> {

    Provincia findByNombre(String nombre);

    List<Provincia> findByNombreIgnoreCaseContaining(String nombre);
}
