package com.bancoa.bancoapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Cliente {
    @Id
    private String dui;
    private String nombre;

    public String getDui() {return dui;}
    public void setDui(String dui) {this.dui = dui;}

    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}
}
