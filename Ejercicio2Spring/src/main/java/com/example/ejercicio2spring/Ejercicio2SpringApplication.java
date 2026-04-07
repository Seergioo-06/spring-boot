package com.example.ejercicio2spring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.core.annotation.Order;

@SpringBootApplication
public class Ejercicio2SpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(Ejercicio2SpringApplication.class, args);


    }
    //Ejercicio1
    //CommandLineRunner: run specific code when the application starts.
    //Si se crean las clases sin anotaciones, Spring no las detecta por ello hay que marcarlas como beans.
    //Para que sean beans debemos poner @component(en este caso).
    //Para controlar el orden bastaría con implementar la anotación order().

    //Ejercicio2
    //Interfaces: las creamos y luego tenemos que hacer su implementación.
    //reciban un objeto MessageService
    //(un objeto de la interfaz, no de la clase que la implementa) como dependencia, usando
    //inyección por constructor: TRADUCCIÓN: en cada clase se implementa la interfaz a través del constructor
    @Component
    public static class SystemOutMessageService implements MessageService{

        @Override
        public void showMessage(String message) {
            System.out.println(message);
        }
    }
    @Component
    @Order(1)
    public static class ProcesoA2 implements CommandLineRunner {
        final MessageService messageService;
        public ProcesoA2(MessageService messageService) {
            this.messageService = messageService;
        }

        @Override
        public void run(String... args) throws Exception {
            System.out.println("Ejecutando: " + this.getClass().getName()+ " mensaje: " + messageService);
        }
    }
    @Component
    @Order(2)
    public static class ProcesoB2 implements CommandLineRunner{
        final MessageService messageService;
        public ProcesoB2(MessageService messageService) {
            this.messageService = messageService;
        }
        @Override
        public void run(String... args) throws Exception {
            System.out.println("Ejecutando: "+this.getClass().getName()+" mensaje: " + messageService);

        }
    }
    @Component
    @Order(3)
    public static class ProcesoC2 implements CommandLineRunner{
        final MessageService messageService;
        public ProcesoC2(MessageService messageService) {
            this.messageService = messageService;
        }
        @Override
        public void run(String... args) throws Exception {
            System.out.println("Ejecutando: " + this.getClass().getName() + " mensaje: " + messageService);
        }
    }
    public void showMessage(String message){
    }

}
