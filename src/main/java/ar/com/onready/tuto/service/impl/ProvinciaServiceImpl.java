package ar.com.onready.tuto.service.impl;

import ar.com.onready.tuto.domain.Provincia;
import ar.com.onready.tuto.repository.ProvinciaRepository;
import ar.com.onready.tuto.service.ProvinciaService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProvinciaServiceImpl implements ProvinciaService {

    private ProvinciaRepository provinciaRepository;

    public ProvinciaServiceImpl(ProvinciaRepository provinciaRepository) {
        this.provinciaRepository = provinciaRepository;
    }

    @Override
    public Provincia buscarPorId(int id) {
        Provincia provincia = provinciaRepository.findOne(id);
        if (provincia != null) {
            return provinciaRepository.findOne(id);
        }
        throw new NoSuchElementException();
    }

    @Override
    public List<Provincia> buscarTodas() {
        return provinciaRepository.findAll();
    }

    @Override
    public Provincia buscarPorNombre(String nombre) {
        Provincia provincia = provinciaRepository.findByNombre(nombre);

        if(provincia != null) {
            return provincia;
        }
        throw new NoSuchElementException();
    }

    @Override
    public List<Provincia> buscarComoNombre(String nombre) {
        List<Provincia> provincias = provinciaRepository.findByNombreIgnoreCaseContaining(nombre);

        if(provincias.size() != 0) {
            return provincias;
        }
        throw new NoSuchElementException();
    }

    @Override
    @Transactional
    public Provincia saveProvincia(Provincia provincia) {
        return provinciaRepository.save(provincia);
    }

}
