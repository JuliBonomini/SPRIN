package ar.com.onready.tuto.service;

import ar.com.onready.tuto.domain.Provincia;

import java.util.List;

public interface ProvinciaService {

    Provincia buscarPorId(int id);

    List<Provincia> buscarTodas();

    Provincia buscarPorNombre(String nombre);

    List<Provincia> buscarComoNombre(String nombre);

    Provincia saveProvincia(Provincia provincia);
}
