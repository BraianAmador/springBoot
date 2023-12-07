package com.educacionit;

import com.educacionit.config.AppConfig;
import com.educacionit.service.BancoService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ProbandoService {
    public static void main(String[] args) throws InterruptedException {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        BancoService bancoService = context.getBean("bancoService", BancoService.class);

        bancoService.extracion();
        bancoService.deposito();
        bancoService.transferencia();

        bancoService.nuevaTransaccion("Cuenta hsbc origen", "cuenta banco destino");

    }
}
