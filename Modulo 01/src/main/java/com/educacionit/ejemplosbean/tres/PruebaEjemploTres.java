package com.educacionit.ejemplosbean.tres;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PruebaEjemploTres {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        PersonaCompleja personaCompleja = (PersonaCompleja) context.getBean("personaCompleja");
        System.out.println(personaCompleja);

        PersonaColeccion pCollection = (PersonaColeccion) context.getBean("personaCollector");
        System.out.println(pCollection);
    }
}
