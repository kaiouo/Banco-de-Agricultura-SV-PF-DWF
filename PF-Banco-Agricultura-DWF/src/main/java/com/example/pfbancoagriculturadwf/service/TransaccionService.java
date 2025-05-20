package com.bancoa.bancoapi.service;

import com.bancoa.bancoapi.dto.TransaccionRequest;
import com.bancoa.bancoapi.model.Cuenta;
import com.bancoa.bancoapi.model.Movimiento;
import com.bancoa.bancoapi.repository.CuentaRepository;
import com.bancoa.bancoapi.repository.MovimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransaccionService {
    @Autowired
    private CuentaRepository cuentaRepo;

    public List<Cuenta> obtenerCuentasPorDUI(String dui) {
        return cuentaRepo.findByDuiCliente(dui);
    }

    public CuentaRepository getCuentaRepo() {return cuentaRepo;}
    public void setCuentaRepo(CuentaRepository cuentaRepo) {this.cuentaRepo = cuentaRepo;}

    public MovimientoRepository getMovimientoRepo() {return movimientoRepo;}
    public void setMovimientoRepo(MovimientoRepository movimientoRepo) {this.movimientoRepo = movimientoRepo;}

    public String abonar(TransaccionRequest req) {
        Cuenta cuenta = cuentaRepo.findByNumeroCuenta(req.getNuemroCuenta());
        if (cuenta==null) return "No se encontró ninguna cuenta";
        cuenta.setSaldo(cuenta.getSaldo() + req.getMonto());
        cuentaRepo.save(cuenta);
        return "El abono se realizó correctamente";
    }

    public String retirar(TransaccionRequest req) {
        Cuenta cuenta = cuentaRepo.findByNumeroCuenta(req.getNumeroCuenta());
        if (cuenta==null || cuenta.getSaldo() < req.getMonto()) return "Fondos insuficientes";
        cuenta.setSaldo(cuenta.getSaldo() - req.getMonto());
        cuentaRepo.save(cuenta);
        return "Retiro realizado correctamente";
    }

    @Autowired
    private MovimientoRepository movimientoRepo;
    private void registrarMovimiento(String tipo, Double monto, String numeroCuenta, String realizadoPor) {
        Movimiento m = new Movimiento();
        m.setTipo(tipo);
        m.setMonto(monto);
        m.setFecha(LocalDateTime.now());
        m.setNumeroCuenta(numeroCuenta);
        m.setRealizadoPor(realizadoPor);
        movimientoRepo.save(m);
    }

    public List<Movimiento> movimientosPorCuenta(String cuenta) {
        return movimientoRepo.findByNumeroCuenta(cuenta);
    }

    public List<Movimiento> movimientosPorEmpleado(String empleado) {
        return movimientoRepo.findByRealizadoPor(empleado);
    }

    public List<Movimiento> filtrarMovimientos(String desde, String hasta, String tipo) {
        LocalDateTime fDesde = LocalDate.parse(desde).atStartOfDay();
        LocalDateTime fHasta = LocalDate.parse(hasta).atTime(23,59,59);
        if (tipo!=null) {
            return movimientoRepo.findAll().stream().filter(m -> m.getFecha().isAfter(fDesde)
            && m.getFecha().isBefore(fHasta) && m.getTipo().equalsIgnoreCase(tipo)).collect(Collectors.toList());
        }
        return movimientoRepo.findAll().stream().filter(m -> m.getFecha().isAfter(fDesde) && m.getFecha().isBefore(fHasta)).collect(Collectors.toList());
    }
}
