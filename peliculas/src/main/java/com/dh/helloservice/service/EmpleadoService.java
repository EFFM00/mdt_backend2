package com.dh.helloservice.service;

import com.dh.helloservice.entity.Empleado;
import com.dh.helloservice.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmpleadoService {

    @Autowired
    EmpleadoRepository empleadoRepository;

    public Empleado create(Empleado empleado){
        return empleadoRepository.save(empleado);
    }

    public Optional<Empleado> update(Empleado empleado){
        if(empleado.getId() != null && findEmpleadoById(empleado.getId()).isPresent()){
            return Optional.of(empleadoRepository.save(empleado));
        } else {
            return null;
        }
    }

    public Optional<Empleado> findEmpleadoById(Long id) {
        Optional<Empleado> empleado = empleadoRepository.findById(id);
        return empleado;
    }
}
