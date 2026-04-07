package com.example.ejercicio5_y_6spring;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class dia {
    @Getter
    @Setter
    private int precipitacion;
    @Setter
    @Getter
    private int temperatura;g
    @Setter
    @Getter
    private int alerta_UV;
    @Getter
    private LocalDate fecha;
    private String imagen;
    public dia(int precipitacion, int temperatura, int alerta_UV, LocalDate fecha) {
        this.precipitacion = precipitacion;
        this.temperatura = temperatura;
        this.alerta_UV = alerta_UV;
        this.fecha = fecha;
    }



}
