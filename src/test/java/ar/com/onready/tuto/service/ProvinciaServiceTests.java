package ar.com.onready.tuto.service;

import ar.com.onready.tuto.TutoApplicationTests;
import ar.com.onready.tuto.domain.Provincia;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.jdbc.JdbcTestUtils;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;

public class ProvinciaServiceTests extends TutoApplicationTests {

    @Autowired
    private ProvinciaService provinciaService;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private EntityManager entityManager;

    @Test
    @WithMockUser(roles = {"user", "admin"})
    public void buscarPorId_conIdValido_devuelveProvincia() {
        Provincia provincia = provinciaService.buscarPorId(5);

        assertEquals(5, provincia.getId());
        assertEquals("San Luis", provincia.getNombre());
        assertEquals(1, provincia.getPaisId());
    }

    @Test(expected = NoSuchElementException.class)
    @WithMockUser(roles = {"user", "admin"})
    public void buscarPorId_conIdInvalido_lanzaException() {
        provinciaService.buscarPorId(0);
    }

    @Test
    public void buscarTodas_conProvinciasExistentes_devuelveListadoProvincias() {
        List<Provincia> provincias = provinciaService.buscarTodas();

        assertEquals(3, provincias.size());
    }

    @Test
    public void buscarPorNombre_conNombreValido_devuelveProvincia() {
        Provincia provincia = provinciaService.buscarPorNombre("Buenos Aires");

        assertEquals(1, provincia.getId());
        assertEquals("Buenos Aires", provincia.getNombre());
        assertEquals(1, provincia.getPaisId());
    }

    @Test(expected = NoSuchElementException.class)
    public void buscarPorNombre_conNombreInexistente_lanzaException() {
        provinciaService.buscarPorNombre("San Juan");
    }

    @Test(expected = NoSuchElementException.class)
    public void buscarPorNombre_conNombreNull_lanzaException() {
        provinciaService.buscarPorNombre(null);
    }

    @Test
    public void buscarPorNombreParecido_conNombreValido_devuelveListadoProvincias() {
        List<Provincia> provincias = provinciaService.buscarComoNombre("mendo");

        assertEquals(1, provincias.size());
    }

    @Test(expected = NoSuchElementException.class)
    public void buscarPorNombreParecido_conNombreInvalido_lanzaException() {
        provinciaService.buscarComoNombre("sal");
    }

    @Test
    @WithMockUser(roles = {"admin"})
    public void crearPorvincia_conProvinciaValida_devuelveSuccess() {
        Provincia provincia = new Provincia();
        provincia.setId(3);
        provincia.setNombre("Salta");
        provincia.setPaisId(1);
        int prevCount = JdbcTestUtils.countRowsInTable(jdbcTemplate, "provincia");

        provinciaService.saveProvincia(provincia);
        entityManager.flush();

        assertEquals(prevCount, JdbcTestUtils.countRowsInTable(jdbcTemplate, "provincia") - 1);
    }

    @Test
    @WithMockUser(roles = {"admin"})
    public void modificarProvincia_conProvinciaExistente_devuelveNuevaProvincia() {
        provinciaService.modificarNombrePorvincia(5, "Salta");
        entityManager.flush();
        int countRowsInTableWhere = JdbcTestUtils.countRowsInTableWhere(jdbcTemplate, "provincia", "nombre='Salta'");

        assertEquals(1, countRowsInTableWhere);
    }


}
