package com.bancoa.bancoapi.dto;

import lombok.Data;

@Data
public class TransaccionRequest {
    private String nuemroCuenta;
    private Double monto;
    private String realizadoPor;

    public String getNuemroCuenta() {return nuemroCuenta;}
    public void setNuemroCuenta(String nuemroCuenta) {this.nuemroCuenta = nuemroCuenta;}

    public Double getMonto() {return monto;}
    public void setMonto(Double monto) {this.monto = monto;}

    public String getRealizadoPor() {return realizadoPor;}
    public void setRealizadoPor(String realizadoPor) {this.realizadoPor = realizadoPor;}
}
