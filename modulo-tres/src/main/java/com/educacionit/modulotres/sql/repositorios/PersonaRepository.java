package com.educacionit.modulotres.sql.repositorios;

import com.educacionit.modulotres.sql.entidades.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, Long> {

}
