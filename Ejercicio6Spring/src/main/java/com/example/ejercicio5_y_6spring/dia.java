package com.example.ejercicio5_y_6spring;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

public class dia {
    @Getter
    @Setter private int precipitacion;
    @Getter @Setter
    private int tempMin; // Mínimas entre 0 y 10
    @Getter @Setter private int tempMax; // Máximas entre 10 y 20
    @Getter @Setter private int alerta_UV;
    @Getter private LocalDate fecha;

    public dia(int precipitacion, int tempMin, int tempMax, int alerta_UV, LocalDate fecha) {
        this.precipitacion = precipitacion;
        this.tempMin = tempMin;
        this.tempMax = tempMax;
        this.alerta_UV = alerta_UV;
        this.fecha = fecha;
    }
}