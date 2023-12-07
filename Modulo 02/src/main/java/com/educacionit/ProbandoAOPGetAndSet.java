package com.educacionit;

import com.educacionit.config.AppConfig;
import com.educacionit.model.Alumno;
import com.educacionit.model.Empleado;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ProbandoAOPGetAndSet {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Alumno alumno = context.getBean("alumno", Alumno.class);
        Empleado empleado = context.getBean("empleado", Empleado.class);

        System.out.println("DNI Alumno: " + alumno.getDni());

        empleado.setId(1L);
        empleado.setLegajo("00000122");

        System.out.println("ID Empleado : " + empleado.getId());
    }
}
