package com.educacionit.config;

import com.educacionit.model.Alumno;
import com.educacionit.service.AlumnoService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.educacionit") //Indica adonde deberia buscar los componentes
public class AppConfig {

    @Bean("alumno")
    public Alumno getBeanAlumno(){
        return new Alumno();
    }

    /*@Bean("service")
    public AlumnoService getAlumnoService(){
        return new AlumnoService();
    }*/
}
