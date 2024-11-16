package com.api.sexshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.Optional;
import java.util.List;

import com.api.sexshop.services.EmpleadoService;
import com.api.sexshop.entities.EmpleadoEntity;


@RestController
@RequestMapping("/sexshop/empleados")
public class EmpleadoController {
    private final EmpleadoService empleadoService;

    @Autowired
    public EmpleadoController(EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    @GetMapping
    public List<EmpleadoEntity> getAllEmpleados() {
        return empleadoService.getEmpleados();
    }

    @GetMapping("/{id}")
    public Optional<EmpleadoEntity> getEmpleado(@PathVariable UUID id) {
        return empleadoService.getEmpleadoById(id);
    }

    @PostMapping
    public String createEmpleado(@RequestBody EmpleadoEntity empleado) {
        return empleadoService.createEmpleado(empleado);
    }

    @PutMapping("/{id}")
    public String updateEmpleado(@PathVariable UUID id, @RequestBody EmpleadoEntity empleado) {
        return empleadoService.updateEmpleadoById(id, empleado);
    }

    @DeleteMapping("/{id}")
    public String deleteEmpleado(@PathVariable UUID id) {
        return empleadoService.deleteEmpleadoById(id);
    }

}
