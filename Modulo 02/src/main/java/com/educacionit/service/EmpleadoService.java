package com.educacionit.service;

import org.springframework.stereotype.Component;

@Component("empleadoService")
public class EmpleadoService {

    public void businessLogic(){
        System.out.println("Empleado haciendo algo ...............");
    }

    public void businessValidation(){
        System.out.println("Validacion de empleado");
    }
}
