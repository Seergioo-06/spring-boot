package com.example.ejercicio4spring;

import Services.MessageService;
import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.core.annotation.Order;

@SpringBootApplication
public class Ejercicio4springApplication {

    public static void main(String[] args) {
        SpringApplication.run(Ejercicio4springApplication.class, args);


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
    //Para que una implementación sea por defecto necesita la anotación @Primary.

    //Ejercicio4
    //Manejo de dependencias: preparar para usar el fucker, tenemos que modificar el pom.xml.
    //faker no se puede modificar por lo que se crea un archivo de configuración(ESENCIAL).
    //QUE HACE FAKER: 
    @Configuration
    public static class configuracionBeans{
        @Bean // Spring ejecutará este método y guardará el objeto Faker en su contexto
        public Faker faker(){
            return new Faker();
        }
    }
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
    public static class ProcesoA4 implements CommandLineRunner {
        final MessageService messageService;
        public ProcesoA4(MessageService messageService) {
            this.messageService = messageService;
        }

        @Override
        public void run(String... args) throws Exception {
            messageService.showMessage("Ejecutando: " + this.getClass().getName());
        }
    }
    @Component
    @Order(2)
    public static class ProcesoB4 implements CommandLineRunner{
        final MessageService messageService;
        public ProcesoB4(@Qualifier("SystemErrMessageService") MessageService messageService) {
            this.messageService = messageService;
        }
        @Override
        public void run(String... args) throws Exception {
            messageService.showMessage("Ejecutando: " + this.getClass().getName());

        }
    }
    @Component
    @Order(3)
    public static class ProcesoC4 implements CommandLineRunner{
        final MessageService messageService;
        public ProcesoC4(MessageService messageService) {
            this.messageService = messageService;
        }
        @Override
        public void run(String... args) throws Exception {
            messageService.showMessage("Ejecutando: " + this.getClass().getName());
        }
    }


}
