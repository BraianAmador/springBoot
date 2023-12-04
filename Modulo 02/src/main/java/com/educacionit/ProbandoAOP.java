package com.educacionit;

import com.educacionit.config.AppConfig;
import com.educacionit.service.AlumnoService;
import com.educacionit.service.EmpleadoService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class ProbandoAOP {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

                                                //Otra forma de castearlo
        //Alumno alumno = context.getBean("alumno", Alumno.class);
        //System.out.println(alumno);

        AlumnoService service = context.getBean("service", AlumnoService.class);
        //System.out.println("Alumno: " + service.getAlumno());

        //crtl + alt + v
        EmpleadoService empleadoService = context.getBean("empleadoService", EmpleadoService.class);

        service.businessLogic("Update de alumno");
        System.out.println("-----------------------------");
        empleadoService.businessLogic();
        System.out.println("-----------------------------");
        empleadoService.businessValidation();
        System.out.println("-----------------------------");
        System.out.println(service.businessGetting());
        System.out.println("-----------------------------");
        service.businessGetting("update alumno");
    }
}
