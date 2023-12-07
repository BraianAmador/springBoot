package com.educacionit.aspect;

import com.educacionit.model.Empleado;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import javax.management.ObjectName;
import java.time.Duration;
import java.time.LocalTime;

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

//    @Before(value="execution(* com.educacionit.service.*.*(..))")
//    public void antesDeLogicaNegocio(){
//        System.out.println(".........Validando Login.............");
//        System.out.println("Login correcto");
//        System.out.println(".........Validando Permisos...........");
//        System.out.println("Permisos correctos");
//        System.out.println("-----------------------------------------");
//    }

    //Expresion que me permite reutilizar las expresiones pointcut
    @Pointcut("execution(* com.educacionit.service.*.businessLogic(..))")
    private void ejecutarAntesDeBusinessLogic(){

    }

    //Esto se ejecuta en todos los set
    @Pointcut("execution(* com.educacionit.model.*.set*(..))")
    private void enTodosLosSet(){

    }

    //Esto se ejecuta en todos los get
    @Pointcut("execution(* com.educacionit.model.*.get*())")
    private void enTodosLosGet(){

    }

    @Before(value="ejecutarAntesDeBusinessLogic()")
    public void login(){
        System.out.println(".........Validando Login.............");
        System.out.println("Login correcto");
        System.out.println("-----------------------------------------");
    }

    @Before(value="ejecutarAntesDeBusinessLogic()")
    public void validarPermisos(){
        System.out.println(".........Validando Permisos...........");
        System.out.println("Permisos correctos");
        System.out.println("-----------------------------------------");
    }

    @Before("enTodosLosSet() || enTodosLosGet()")
    public void enTodosLosSetOGet(){
        System.out.println("Antes de un SET o un GET");
        System.out.println("******************************************");
    }

    //Se ejecuta despues del retorno
    @AfterReturning(
            pointcut = "execution(* com.educacionit.service.AlumnoService.getAlumno())",
            returning = "valorRetorno"
    )
    public void validarElRetorno(Object valorRetorno){
        /*if(valorRetorno != null) {
            System.out.println("Alumno retorno: " + valorRetorno);
        }*/


        //Como es empleador no muestra el valor de retorno porque el pointcut especifica que es solo para alumnos
        if(valorRetorno instanceof Empleado){
            System.out.println("Valor retornado: " + valorRetorno );
        }
    }

    @AfterThrowing(
            pointcut = "execution(* com.educacionit.service.*.*(..))",
            throwing = "excepcionObtenida"
    )
    public void validarExcepcion(Throwable excepcionObtenida){
        if(excepcionObtenida instanceof RuntimeException){
            System.out.println("Se ejecuta la validacion de excepcion");
            System.out.println(excepcionObtenida.getMessage());
        }

    }

    @Around("execution(* com.educacionit.service.EmpleadoService.haciendoAlgo())")
    public Object antesYDespues(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("Antes de la ejecucion de metodo");

        Object resultado = proceedingJoinPoint.proceed();

        System.out.println("Resultado obtenido: " + resultado);

        System.out.println("Despues de la ejecucion del metodo");

        return null;
    }

    @Around("execution(* com.educacionit.service.BancoService.*(..))")
    public Object calcularTiempos(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        LocalTime inicio = LocalTime.now();

        proceedingJoinPoint.proceed();

        LocalTime fin = LocalTime.now();

        long segundos = Duration.between(inicio, fin).getSeconds();

        String nombreMetodo = proceedingJoinPoint.getSignature().getName();

        System.out.println("La operacion de" + nombreMetodo + "tardo un tiempo de " + segundos + "segundo/s");

        return null;
    }

    @After(("execution(* com.educacionit.service.BancoService.nuevaTransaccion(..))"))
    public void capturadorDeArgumentos(JoinPoint joinPoint){
        Object[] argumentos = joinPoint.getArgs();
        for(Object obj : argumentos) {
            System.out.println(obj);
        }

    }

}
