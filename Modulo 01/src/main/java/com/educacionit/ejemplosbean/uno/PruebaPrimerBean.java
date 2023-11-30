package com.educacionit.ejemplosbean.uno;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PruebaPrimerBean {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        PrimerBean bean = (PrimerBean) context.getBean("miPrimerBean");
        System.out.println(bean);
        bean.mostrarMensaje("Hemos generado nuestro primer bean");
    }
}
