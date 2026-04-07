package com.example.ejercicio6spring.PersonaService;

import com.example.ejercicio6spring.persona;

import java.util.List;

public interface personaInterface {
    List<persona> find(int count); //devuelve una lista de todas las personas
    persona findOne(); //devuelve de manera aleatoria

}
