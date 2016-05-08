package net.siekiera.mgc.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Klasa przechowuje informacje o elemencie wyposażenia (np ABS, Elektryczne szyby)
 */
@Entity
@Table(name = "elementy_wyposazenia")
public class ElementWyposazenia {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    private String nazwa;

    public ElementWyposazenia() {
    }

    public ElementWyposazenia(Integer id, String nazwa) {
        this.id = id;
        this.nazwa = nazwa;
    }

    public ElementWyposazenia(String nazwa) {
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
        return "ElementWyposazenia{" +
                "id=" + id +
                ", nazwa='" + nazwa + '\'' +
                '}';
    }
}
