package com.educacionit.modulotres.sql.entidades;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity //para que sea una entidad mapeada a mi base de datos
@Table(name = "personas")// Para que me genere otro nombre en la tabla de la base de datos
public class Persona implements Serializable { //implements Serializable sto no es obligatorio

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Para que el id sea autoincremental
    private Long id;

    @Column(nullable = false, length = 80) //Que no permita valores nulos y una longitud de 80
    private String nombre;

    @Column(nullable = false, length = 50, name = "apellidos")
    private String apellido;

    @Column(unique = true, length = 12, nullable = false)
    private String dni;

    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

    @OneToMany(
            mappedBy = "persona", //Para que no me genere una tabla intermedia
            fetch = FetchType.LAZY, //si trabajo con ToMany
            orphanRemoval = true
    )
    private List<Domicilio> domicilios;

    public Persona() {
    }

    public Persona(Long id, String nombre, String apellido, String dni) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public List<Domicilio> getDomicilios() {
        return domicilios;
    }

    public void setDomicilios(List<Domicilio> domicilios) {
        this.domicilios = domicilios;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni='" + dni + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                '}';
    }
}
