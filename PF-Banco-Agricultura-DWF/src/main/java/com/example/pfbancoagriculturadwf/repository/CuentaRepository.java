package com.bancoa.bancoapi.repository;

import com.bancoa.bancoapi.model.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CuentaRepository extends JpaRepository<Cuenta, Long> {
    List<Cuenta> findByDuiCliente(String dui);
    Cuenta findByNumeroCuenta(String numeroCuenta);
}
