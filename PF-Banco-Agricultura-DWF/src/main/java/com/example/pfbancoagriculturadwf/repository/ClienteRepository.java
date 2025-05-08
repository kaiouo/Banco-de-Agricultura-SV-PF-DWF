package com.bancoa.bancoapi.repository;

import com.bancoa.bancoapi.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, String> {
}
