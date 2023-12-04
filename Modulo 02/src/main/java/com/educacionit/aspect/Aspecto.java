package com.educacionit.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Aspecto {

    /*Se ejecuta el aspecto para todo lo metodos de acceso publico de retorno void y
    que se llame businessLogic y sin argumentos*/
    //@Before(value = "execution(public void businessLogic())") Que se ejecute antes de

    //Se ejecuta el aspecto solamente para el metodo publico de retorno void y que se llame
    // businessLogic del AlumnoService
    //@Before(value = "execution(public void com.educacionit.service.AlumnoService.businessLogic())")

    //Se ejecuta el aspecto cuando el metodo es publico sin retorno sin argumentos y comience con la palabra business
    //@Before(value = "execution(public void business*())")

    //Se ejecuta el aspecto cuando el metodo es de acceso publico, sin importar el tipo de retorno
    //que sea sin argumentos y que comience con la palabra business
    //@Before(value="execution(public * business*())")

    //Se ejecuta el aspecto cuando es de acceso publico sin importar el tipo de retorno, que se llame businessLogic
    // y que tenga uno o mas argumentos
    //@Before(value = "execution(public * businessLogic(..))")
    //businessLogic(..) => (dos puntos) ejecuta tenga o no argumentos
    //businessLogic(*) => (asterisco) ejecuta si contiene argumento

    @Before(value="execution(* com.educacionit.service.*.*(..))")
    public void antesDeLogicaNegocio(){
        System.out.println(".........Validando Login.............");
        System.out.println("Login correcto");
        System.out.println(".........Validando Permisos...........");
        System.out.println("Permisos correctos");
        System.out.println("-----------------------------------------");
    }


}
