package com.bancoa.bancoapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Movimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tipo; //abono o retiro
    private Double monto;
    private LocalDateTime fecha;
    private String numeroCuenta;
    private String realizadoPor;

    public String getTipo() {return tipo;}
    public void setTipo(String tipo) {this.tipo = tipo;}


    public Double getMonto() {return monto;}
    public void setMonto(Double monto) {this.monto = monto;}

    public LocalDateTime getFecha() {return fecha;}
    public void setFecha(LocalDateTime fecha) {this.fecha = fecha;}

    public String getNumeroCuenta() {return numeroCuenta;}
    public void setNumeroCuenta(String numeroCuenta) {this.numeroCuenta = numeroCuenta;}

    public String getRealizadoPor() {return realizadoPor;}
    public void setRealizadoPor(String realizadoPor) {this.realizadoPor = realizadoPor;}

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
}
