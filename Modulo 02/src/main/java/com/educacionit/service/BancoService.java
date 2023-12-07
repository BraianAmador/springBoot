package com.educacionit.service;


import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class BancoService {

    public void transferencia() throws InterruptedException {
        Random random = new Random();
        int milisegundos = random.ints(1000,5000)
                .findFirst()
                .getAsInt();
        Thread.sleep(milisegundos);
    }

    public void deposito() throws InterruptedException {
        Random random = new Random();
        int milisegundos = random.ints(1000,5000)
                .findFirst()
                .getAsInt();
        Thread.sleep(milisegundos);
    }

    public void extracion() throws InterruptedException {
        Random random = new Random();
        int milisegundos = random.ints(1000,5000)
                .findFirst()
                .getAsInt();
        Thread.sleep(milisegundos);
    }

    public void nuevaTransaccion(String cuentaOrigen, String cuentaDestino){
        System.out.println("******************************");
    }

}
