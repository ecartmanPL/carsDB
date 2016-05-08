package net.siekiera.mgc.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Klasa przechowuje informacje o marce (VW, Audi, Mercedes etc)
 */
@Entity
@Table(name = "marki")
public class Marka {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotNull
    private String nazwa;

    public Marka() {
    }

    public Marka(Integer id, String nazwa) {
        this.id = id;
        this.nazwa = nazwa;
    }

    public Marka (String nazwa) {
        this.nazwa = nazwa;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    @Override
    public String toString() {
        return "Marka{" +
                "id=" + id +
                ", nazwa='" + nazwa + '\'' +
                '}';
    }
}
