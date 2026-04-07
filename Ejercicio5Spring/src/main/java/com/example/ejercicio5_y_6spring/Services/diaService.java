package com.example.ejercicio5_y_6spring.Services;

import com.example.ejercicio5_y_6spring.dia;
import com.example.ejercicio5_y_6spring.persona;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class diaService {
    private final Random random = new Random();

    public List<dia> ObtenerSemana() {
        List<dia> semana = new ArrayList<>();
        LocalDate hoy = LocalDate.now();
        for(int i=0; i < 7; i++) { // Siete días desde hoy
            LocalDate fecha = hoy.plusDays(i);
            int precipitacion = random.nextInt(101); // 0% a 100%
            int tempMin = random.nextInt(11); // 0 a 10
            int tempMax = 10 + random.nextInt(11); // 10 a 20
            int alerta_UV = random.nextInt(6); // 0 a 5

            semana.add(new dia(precipitacion, tempMin, tempMax, alerta_UV, fecha));
        }
        return semana;
    }


}
