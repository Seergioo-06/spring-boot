package com.example.ejercicio5_y_6spring.Services;

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
