package com.example.festivos_api.model;

import jakarta.persistence.*;

@Entity
public class Festivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int dia;
    private int mes;
    private String nombre;
    private int tipo;
    private int diasDesdePascua;

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getDiasDesdePascua() {
        return diasDesdePascua;
    }

    public void setDiasDesdePascua(int diasDesdePascua) {
        this.diasDesdePascua = diasDesdePascua;
    }
}
