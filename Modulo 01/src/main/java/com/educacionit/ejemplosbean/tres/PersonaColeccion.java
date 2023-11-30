package com.educacionit.ejemplosbean.tres;

import java.util.List;

public class PersonaColeccion {
    private Long id;
    private String nombre;
    private List<Domicilio> domicilio;

    public PersonaColeccion() {
    }

    public PersonaColeccion(Long id, String nombre, List<Domicilio> domicilio) {
        this.id = id;
        this.nombre = nombre;
        this.domicilio = domicilio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Domicilio> getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(List<Domicilio> domicilio) {
        this.domicilio = domicilio;
    }

    @Override
    public String toString() {
        return "PersonaColeccion{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", domicilio=" + domicilio +
                '}';
    }
}
