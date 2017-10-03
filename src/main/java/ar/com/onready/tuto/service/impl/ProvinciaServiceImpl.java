package ar.com.onready.tuto.service.impl;

import ar.com.onready.tuto.domain.Provincia;
import ar.com.onready.tuto.repository.ProvinciaRepository;
import ar.com.onready.tuto.repository.impl.ProvinciaRepositoryImpl;
import ar.com.onready.tuto.service.ProvinciaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinciaServiceImpl implements ProvinciaService {

    private ProvinciaRepository provinciaRepository;

    public ProvinciaServiceImpl(ProvinciaRepository provinciaRepository) {
        this.provinciaRepository = provinciaRepository;
    }

    public Provincia buscarPorId(int id) {
        return provinciaRepository.buscarPorId(id);
    }

    public List<Provincia> buscarTodas() {
        return provinciaRepository.buscarTodas();
    }

}
