package com.example.ejercicio1spring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.core.annotation.Order;

@SpringBootApplication
public class Ejercicio1SpringApplication {
    public static void main(String[] args) {
        SpringApplication.run(Ejercicio1SpringApplication.class, args);


    }
    //Si se crean las clases sin anotaciones, Spring no las detecta por ello hay que marcarlas como beans.
    //Para que sean beans debemos poner @component(en este caso).
    //Para controlar el orden bastaría con implementar la anotación order().
    @Component
    @Order(1)
    public static class ProcesoA implements CommandLineRunner {

        @Override
        public void run(String... args) throws Exception {
            System.out.println("Ejecutando: " + this.getClass().getName());
        }
    }
    @Component
    @Order(2)
    public static class ProcesoB implements CommandLineRunner{

        @Override
        public void run(String... args) throws Exception {
            System.out.println("Ejecutando: "+this.getClass().getName());

        }
    }
    @Component
    @Order(3)
    public static class ProcesoC implements CommandLineRunner{
        @Override
        public void run(String... args) throws Exception {
            System.out.println("Ejecutando: " + this.getClass().getName());
        }
    }

}
