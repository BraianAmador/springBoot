package com.educacionit.modulotres.sql.entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "domicilios")
public class Domicilio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String calle;
    private Integer altura;
    private Integer codigoPostal;

    @ManyToOne(
            cascade = { CascadeType.ALL }, //ejemplo si eliminamos algo lo mismo hara con la entidad que lo relaciona Se pasa a la entidad relacionada
            optional = true //Acepta o no objectos nulos
    )
    @JoinColumn(name = "persona_id")
    private Persona persona;

    public Domicilio() {
    }

    public Domicilio(Long id, String calle, Integer altura, Integer codigoPostal) {
        this.id = id;
        this.calle = calle;
        this.altura = altura;
        this.codigoPostal = codigoPostal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public Integer getAltura() {
        return altura;
    }

    public void setAltura(Integer altura) {
        this.altura = altura;
    }

    public Integer getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(Integer codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    @Override
    public String toString() {
        return "Domicilio{" +
                "id=" + id +
                ", calle='" + calle + '\'' +
                ", altura=" + altura +
                ", codigoPostal=" + codigoPostal +
                '}';
    }
}
