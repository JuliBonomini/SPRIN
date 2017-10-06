package ar.com.onready.tuto.controller;

import ar.com.onready.tuto.domain.Provincia;
import ar.com.onready.tuto.service.ProvinciaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProvinciasController {

    private ProvinciaService provinciaService;

    public ProvinciasController(ProvinciaService provinciaService) {
        this.provinciaService = provinciaService;
    }

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("provincia", provinciaService.buscarPorId(1));
        return "home";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @GetMapping("/provincias")
    public String provincias(Model model) {
        List<Provincia> provincias = provinciaService.buscarTodas();
        model.addAttribute("provincia", provincias);
        return "provincias";
    }

    @GetMapping("/provincia")
    public String provincia(Model model) {
        Provincia provincia = new Provincia();
        model.addAttribute("provincia", provincia);
        return "provincia";
    }

    @PostMapping("/provincia")
    public String provincia(@ModelAttribute(value = "provincia") Provincia provincia) {
        provinciaService.saveProvincia(provincia);
        return "redirect:/provincias";
    }
}
