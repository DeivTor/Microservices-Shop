package com.api.sexshop.services;
import java.util.Optional;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.api.sexshop.entities.ClienteEntity;
import com.api.sexshop.entities.EmpleadoEntity;
import com.api.sexshop.repositories.EmpleadosRepository;
import org.springframework.stereotype.Service;

@Service
public class EmpleadoService {

    private EmpleadosRepository empleadosRepository;

    public EmpleadoService() {

    }

    //(GET){READ - ALL}
    public List<EmpleadoEntity> getEmpleados() {
        List<EmpleadoEntity> empleados = empleadosRepository.findAll();
        return empleados;
    }

    //(GET){READ - ID}
    public Optional<EmpleadoEntity> getEmpleadoById(UUID id) {
        Optional<EmpleadoEntity> empleadoFound = empleadosRepository.findById(id);
        if(empleadoFound.isPresent()) {
            return empleadoFound;
        }else{
            return Optional.empty();
        }
    }

    //(POST){CREATE}
    public String createEmpleado(EmpleadoEntity empleado) {
        empleado.setId(UUID.randomUUID());
        if (empleadosRepository.existsById(empleado.getId())) {
            return "Ese Empleado ya existe";
        }else {
            empleadosRepository.save(empleado);
            return "Empleado creado con exito";
        }
    }

    //(PUT){UPDATE}
    public String updateEmpleadoById(UUID id, EmpleadoEntity empleado) {
        Optional<EmpleadoEntity> empleadoFound = getEmpleadoById(id);
        if(empleadoFound.isPresent()) {
            empleadosRepository.save(empleado);
            return "Empleado actualizado con exito";
        }else {
            return "Empleado no encontrado";
        }
    }

    //(DELETE){DELETE}
    public String deleteEmpleadoById(UUID id) {
        Optional<EmpleadoEntity> empleadoFound = getEmpleadoById(id);
        if(empleadoFound.isPresent()) {
            empleadosRepository.delete(empleadoFound.get());
            return "Empleado eliminado con exito";
        }else{
            return "Empleado no encontrado";
        }
    }
}
