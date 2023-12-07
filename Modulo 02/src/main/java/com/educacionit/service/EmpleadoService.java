package com.educacionit.service;

import org.springframework.stereotype.Component;

@Component("empleadoService")
public class EmpleadoService {

    public void businessLogic(){
        System.out.println("Empleado haciendo algo ...............");
    }

    public void businessValidation(){ System.out.println("Validacion de empleado");}

    public void ocurrioUnaException(){
        throw new RuntimeException("Ocurrio un error en el servicio de empleado");
    }

    public void haciendoAlgo(){
        System.out.println("Estoy haciendo algo en el servicio de empleados ................");
    }

    public String haciendoAlgoConRetorno(){
        return "Metodo que retorno un string";
    }
}
