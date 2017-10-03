package ar.com.onready.tuto.controller;

import ar.com.onready.tuto.service.ProvinciaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}
