package com.example.ejercicio6spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Ejercicio5
 * Necesitamos crear la persona con sus atributos.
 * Una interfaz que en este caso va a ser la encargada de coordinar el find(int count) y el find One
 * Para ello listamos a las personas para que según lo que pidamos saque una o todas.
 * El service ser encarga de implementar el faker, la interfaz y gestionar la lógica de datos(creación de personas mediante el faker)
 * El controller, no sabe nada de lo que hacer el service solo se encarga de pedir al servicio que encuentre lo solicitado.
 * PersonaController se encarga de manejar según se pida la información a una o toda la información.
 * HomeController en cambio, solo es para que todo aquellos que accedan a la raíz (/) les aparezca un mensaje de bienvenida.
 */
@SpringBootApplication(scanBasePackages = "com.example.ejercicio6spring")
public class Ejercicio6SpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(Ejercicio6SpringApplication.class, args);


    }

}
