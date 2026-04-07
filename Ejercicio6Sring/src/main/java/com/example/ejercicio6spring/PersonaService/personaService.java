package com.example.ejercicio6spring.PersonaService;

import com.example.ejercicio6spring.persona;
import net.datafaker.Faker;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service //Anotaciones para que el programa sepa que es un servicio.
public class personaService  implements personaInterface {
    //Implementación del faker, lo inyectamos como dependencia en la impelmentación del servicio.
    private final Faker faker;

    public personaService(Faker faker) {
        this.faker = faker;
    }
//Aquí se almacenan las personas para que cuando las pidamos aparezcan
@Override
public persona findOne() {
    return new persona(
            faker.name().firstName(),
            faker.name().lastName(),
            faker.idNumber().valid(),
            faker.timeAndDate().birthday(18, 80)
    );
}
    @Override
    public List<persona> find(int count) {
        List<persona> lista = new ArrayList<>();
        for (int i = 1; i <= count; i++) {
            persona p = findOne();
                lista.add(p);

        }
        return lista;
    }
//Usamos el dataFaker para generar datos realistas de personas y se crean a través del find(int count)


}
