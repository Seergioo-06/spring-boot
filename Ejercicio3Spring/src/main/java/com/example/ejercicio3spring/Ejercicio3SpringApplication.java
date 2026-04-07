package com.example.ejercicio3spring;

import Services.MessageService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.core.annotation.Order;

@SpringBootApplication
public class Ejercicio3SpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(Ejercicio3SpringApplication.class, args);


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
    //inyección por constructor: TRADUCCIÓN: en cada clase se implementa la interfaz a través del constructor.

    //Ejercicio3
    //Implementar la interfaz pero para errores y usar anotaciones para manejar cuando usar una u otra.
    //La anotación @cualifier soluciona el problema de dos o más clases que usan la misma interfaz, nosotros elegimos cuál queremos,
    //en las class Proceso.
    //Para que una implementación sea por defecto necesita la anotación @Primary
    @Component("SystemOutMessageService")
    @Primary
    public static class SystemOutMessageService implements MessageService {

        @Override
        public void showMessage(String message) {
            System.out.println(message);
        }
    }
    @Component("SystemErrMessageService")
    public static class SystemErrMessageService implements MessageService{
        @Override
                public void showMessage(String message){
            System.err.println("Error: " + message);
        }
    }
    @Component
    @Order(1)
    public static class ProcesoA3 implements CommandLineRunner {
        final MessageService messageService;
        public ProcesoA3(MessageService messageService) {
            this.messageService = messageService;
        }

        @Override
        public void run(String... args) throws Exception {
            messageService.showMessage("Ejecutando: " + this.getClass().getName());
        }
    }
    @Component
    @Order(2)
    public static class ProcesoB3 implements CommandLineRunner{
        final MessageService messageService;
        public ProcesoB3(@Qualifier("SystemErrMessageService") MessageService messageService) {
            this.messageService = messageService;
        }
        @Override
        public void run(String... args) throws Exception {
            messageService.showMessage("Ejecutando: " + this.getClass().getName());

        }
    }
    @Component
    @Order(3)
    public static class ProcesoC3 implements CommandLineRunner{
        final MessageService messageService;
        public ProcesoC3( MessageService messageService) {
            this.messageService = messageService;
        }
        @Override
        public void run(String... args) throws Exception {
            messageService.showMessage("Ejecutando: " + this.getClass().getName());
        }
    }


}
