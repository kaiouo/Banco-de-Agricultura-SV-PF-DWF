package com.bancoa.bancoapi.repository;

import com.bancoa.bancoapi.model.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovimientoRepository extends JpaRepository<Movimiento, Long> {
    List<Movimiento> findByNumeroCuenta(String numeroCuenta);
    List<Movimiento> findByRealizadoPor(String empleado);
}
