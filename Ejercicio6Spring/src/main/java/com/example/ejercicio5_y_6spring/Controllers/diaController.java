package com.example.ejercicio5_y_6spring.Controllers;

import com.example.ejercicio5_y_6spring.Services.diaService;
import com.example.ejercicio5_y_6spring.dia;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/personas")
public class diaController {
    private final diaService diaService;
    public diaController(diaService diaService) {
        this.diaService = diaService;
    }
    @GetMapping("/prediccion")
    public String prediccion(Model model){
        List<dia> semana = diaService.ObtenerSemana();
        model.addAttribute("semana", semana);
        return "/personas/prediccion";
    }
}
