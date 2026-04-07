package com.example.ejercicio6spring;

import java.time.LocalDate;
import java.time.Period;

public class persona {
    private String  nombre;
    private String apellido;
    private String DNI;
    private LocalDate fechaNacimiento;

    public persona(String nombre, String apellido, String DNI, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.DNI = DNI;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    public int getEdad(){
        return Period.between(fechaNacimiento, LocalDate.now()).getYears();
    }
}
