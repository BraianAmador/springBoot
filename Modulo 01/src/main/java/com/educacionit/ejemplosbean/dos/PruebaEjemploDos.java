package com.educacionit.ejemplosbean.dos;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PruebaEjemploDos {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Persona persona = (Persona) context.getBean("persona");
        Persona personaDos = (Persona) context.getBean("persona2");
        System.out.println(persona);
        System.out.println("**************************************");
        System.out.println(personaDos);
    }
}
