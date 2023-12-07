package com.educacionit.modulotres.sql.comandos;

import com.educacionit.modulotres.sql.entidades.Persona;
import com.educacionit.modulotres.sql.repositorios.DomicilioRepository;
import com.educacionit.modulotres.sql.repositorios.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Optional;

@Component
public class ComandosSQL implements CommandLineRunner {

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private DomicilioRepository domicilioRepository;

    @Override
    public void run(String... args) throws Exception {

        //Persona persona = new Persona(null, "Nombre Persona", "Apellido Persona", "11111111");
        //personaRepository.save(persona);

        Optional<Persona> aPersona = personaRepository.findById(1L);
        Persona personaById = null;

        if(aPersona.isPresent()){
            personaById = aPersona.get();
            personaById.setFechaNacimiento(LocalDate.of(1992,3, DayOfWeek.SUNDAY.getValue()));
        }

        personaRepository.save(personaById);

        System.out.println(personaById);
    }
}
