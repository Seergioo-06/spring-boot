package com.example.ejercicio6spring.PersonaService;

import net.datafaker.Faker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class configuracionFaker{
    @Bean
    public Faker faker(){
        return new Faker();
    }
    
}
