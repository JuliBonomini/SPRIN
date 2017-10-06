package ar.com.onready.tuto.service.impl;

import ar.com.onready.tuto.domain.Provincia;
import ar.com.onready.tuto.repository.ProvinciaRepository;
import ar.com.onready.tuto.service.ProvinciaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Slf4j
public class ProvinciaServiceImpl implements ProvinciaService {

    private final ProvinciaRepository provinciaRepository;

    public ProvinciaServiceImpl(ProvinciaRepository provinciaRepository) {
        this.provinciaRepository = provinciaRepository;
    }

    @Override
//    @PreAuthorize("hasRole('admin')")
    public Provincia buscarPorId(int id) {
        Provincia provincia = provinciaRepository.findOne(id);

        if (provincia != null) {
            return provinciaRepository.findOne(id);
        }
        log.info("Hola");
        throw new NoSuchElementException();
    }

    @Override
    public List<Provincia> buscarTodas() {
        return provinciaRepository.findAll();
    }

    @Override
    public Provincia buscarPorNombre(String nombre) {
        Provincia provincia = provinciaRepository.findByNombre(nombre);

        if (provincia != null) {
            return provincia;
        }
        throw new NoSuchElementException();
    }

    @Override
    public List<Provincia> buscarComoNombre(String nombre) {
        List<Provincia> provincias = provinciaRepository.findByNombreIgnoreCaseContaining(nombre);

        if (provincias.isEmpty()) {
            throw new NoSuchElementException();
        } else {
            return provincias;
        }
    }

    @Override
    @Transactional
//    @PreAuthorize("hasRole('admin')")
    public Provincia saveProvincia(Provincia provincia) {
        return provinciaRepository.save(provincia);
    }

    @Override
    @Transactional
    public Provincia modificarNombrePorvincia(int id, String nombre) {
        Provincia provincia = provinciaRepository.findOne(id);
        provincia.setNombre(nombre);
        return provincia;
    }

}
