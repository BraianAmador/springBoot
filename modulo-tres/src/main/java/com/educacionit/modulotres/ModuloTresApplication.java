package com.educacionit.modulotres;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication()//(exclude = {DataSourceAutoConfiguration.class })//Excluyo los componentes de base de datos
public class ModuloTresApplication {

    public static void main(String[] args) {
        SpringApplication.run(ModuloTresApplication.class, args);
    }

}
