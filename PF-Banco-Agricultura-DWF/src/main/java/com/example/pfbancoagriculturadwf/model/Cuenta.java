package com.bancoa.bancoapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cuenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numeroCuenta;
    private String duiCliente;
    private Double saldo;

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public String getNumeroCuenta() {return numeroCuenta;}

    public String getDuiCliente() {return duiCliente;}
    public void setDuiCliente(String duiCliente) {this.duiCliente = duiCliente;}

    public Double getSaldo() {return saldo;}
    public void setSaldo(Double saldo) {this.saldo = saldo;}
}
