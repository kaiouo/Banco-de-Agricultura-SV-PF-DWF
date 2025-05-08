package com.bancoa.bancoapi.controller;

import com.bancoa.bancoapi.dto.TransaccionRequest;
import com.bancoa.bancoapi.model.Cuenta;
import com.bancoa.bancoapi.model.Cliente;
import com.bancoa.bancoapi.model.Movimiento;
import com.bancoa.bancoapi.repository.ClienteRepository;
import com.bancoa.bancoapi.repository.MovimientoRepository;
import com.bancoa.bancoapi.service.TransaccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TransaccionController {
    @Autowired
    private TransaccionService transaccionService;

    @GetMapping("/cuentas/{dui}")
    public List<Cuenta> obtenerCuentasPorDUI(@PathVariable String dui) {
        return transaccionService.obtenerCuentasPorDUI(dui);
    }

    @PostMapping("/abonaefectivo")
    public ResponseEntity<String> abonar(@RequestBody TransaccionRequest req) {
        return ResponseEntity.ok(transaccionService.abonar(req));
    }

    @PostMapping("/retiraefectivo")
    public ResponseEntity<String> retirar(@RequestBody TransaccionRequest req) {
        return ResponseEntity.ok(transaccionService.retirar(req));
    }

    @GetMapping("/movimientos/{cuenta}")
    public List<Movimiento> movimientosPorCuenta(@PathVariable String cuenta) {
        return transaccionService.movimientosPorCuenta(cuenta);
    }

    @GetMapping("/movimientos/empleado/{empleado}")
    public List<Movimiento> movimientosPorEmpleado(@PathVariable String empleado) {
        return transaccionService.movimientosPorEmpleado(empleado);
    }

    private MovimientoRepository movimientoRepo;
    private ClienteRepository clienteRepo;
    @GetMapping("/clientes")
    public List<Cliente> listarClientes() {
        return clienteRepo.findAll();
    }

    @GetMapping("/movimientos")
    public List<Movimiento> listarMovimientos() {
        return movimientoRepo.findAll();
    }

    @GetMapping("/movimientos/filtro")
    public List<Movimiento> filtrarMovimientos
            (@RequestParam String desde,
            @RequestParam String hasta,
            @RequestParam(required = false) String tipo)
    {return transaccionService.filtrarMovimientos(desde, hasta, tipo);}
}
