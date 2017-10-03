package ar.com.onready.tuto.repository;

import ar.com.onready.tuto.domain.Provincia;

import java.util.List;

public interface ProvinciaRepository {

    Provincia buscarPorId(int id);

    List<Provincia> buscarTodas();
}
