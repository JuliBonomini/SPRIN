package ar.com.onready.tuto.repository.impl;

import ar.com.onready.tuto.domain.Provincia;
import ar.com.onready.tuto.repository.ProvinciaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Repository
public class ProvinciaRepositoryImpl implements ProvinciaRepository {

    private List<Provincia> provincias = new ArrayList<Provincia>();

    public ProvinciaRepositoryImpl() {
        provincias.add(new Provincia(1,"Buenos Aires", 1));
        provincias.add(new Provincia(2,"San Juan", 1));
        provincias.add(new Provincia(5,"San Luis", 1));
    }

    public Provincia buscarPorId(int id) {
        for (Provincia provincia: provincias) {
            if(provincia.getId() == id) {
                return provincia;
            }
        }
        throw new NoSuchElementException();
    }

    public List<Provincia> buscarTodas() {
        return provincias;
    }
}
