package com.example.ejercicio5_y_6spring.Controllers;

import com.example.ejercicio5_y_6spring.Services.personaService;
import com.example.ejercicio5_y_6spring.persona;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/personas")
 //Ya engloba las rutas por debajo de /personas
public class personaController  {
    private final personaService personaService;

    public personaController(personaService personaService) {
        this.personaService = personaService;
    }
    @GetMapping("/listado")
    public String listado(Model model){
        //Pedimos EJEMPLO: 15 personas, cada vez que la ruta sea GET /personas
        //Model es el "camión" en el cual echamos los datos a través de addAtrribute y luego estará disponible en el HTML.
        List<persona> personas = personaService.find(15);
        model.addAttribute("personas",personas);
        return "personas/listado";
    }
    @GetMapping("/una")
    public String mostrarUno(Model model){
        persona p = personaService.findOne();
        model.addAttribute("persona",p);
        return "personas/detalle";
    }



}
