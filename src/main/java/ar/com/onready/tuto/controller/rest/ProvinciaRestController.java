package ar.com.onready.tuto.controller.rest;

import ar.com.onready.tuto.domain.Provincia;
import ar.com.onready.tuto.service.ProvinciaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/provincias")
public class ProvinciaRestController {

    private ProvinciaService provinciaService;

    public ProvinciaRestController(ProvinciaService provinciaService) {
        this.provinciaService = provinciaService;
    }

    @GetMapping
    public List<Provincia> buscar() {
        return provinciaService.buscarTodas();
    }

    @GetMapping(params = "id")
    public Provincia buscar(@RequestParam int id) {
        return provinciaService.buscarPorId(id);
    }

    @GetMapping(params = "nombre")
    public Provincia buscar(@RequestParam String nombre) {
        return provinciaService.buscarPorNombre(nombre);
    }

    @PostMapping
    public Provincia saveProvincia(@RequestBody Provincia provincia) {
        return provinciaService.saveProvincia(provincia);
    }
}
