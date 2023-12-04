package com.educacionit.service;

import com.educacionit.model.Alumno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//Sino le defino un nombre a component, toma el nombre de la clase
@Component("service")
public class AlumnoService {

    @Autowired
    private Alumno alumno;

    public Alumno getAlumno() {
        return alumno;
    }

    public void businessLogic(String update_de_alumno){
        System.out.println("Alumno haciendo algo ...............");
    }

    public String businessGetting() {
        return "Alumno retorna String service";
    }

    public void businessGetting(String mensaje) {
        System.out.println("Haciendo algo alumno " + mensaje);
    }

}
