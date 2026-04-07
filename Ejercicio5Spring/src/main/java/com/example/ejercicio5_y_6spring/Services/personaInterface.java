package com.example.ejercicio5_y_6spring.Services;

import com.example.ejercicio5_y_6spring.persona;

import java.util.List;

public interface personaInterface {
    List<persona> find(int count); //devuelve una lista de todas las personas
    persona findOne(); //devuelve de manera aleatoria

}
