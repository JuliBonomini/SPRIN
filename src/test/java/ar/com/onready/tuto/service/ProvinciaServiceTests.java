package ar.com.onready.tuto.service;

import ar.com.onready.tuto.domain.Provincia;
import ar.com.onready.tuto.repository.impl.ProvinciaRepositoryImpl;
import ar.com.onready.tuto.service.impl.ProvinciaServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProvinciaServiceTests {

    @Autowired
    private ProvinciaService provinciaService;

    @Test
    public void buscarPorId_conIdValido_devuelveProvincia () {
        Provincia provincia = provinciaService.buscarPorId(5);

        assertEquals(5, provincia.getId());
        assertEquals("San Luis", provincia.getNombre());
        assertEquals(1, provincia.getPaisId());
    }

    @Test(expected = NoSuchElementException.class)
    public void buscarPorId_conIdInvalido_lanzaException () {
        provinciaService.buscarPorId(0);
    }

    @Test
    public void buscarTodas_conProvinciasExistentes_devuelveListadoProvincias() {
        List<Provincia> provincias = provinciaService.buscarTodas();

        assertEquals(3, provincias.size());
    }

}
