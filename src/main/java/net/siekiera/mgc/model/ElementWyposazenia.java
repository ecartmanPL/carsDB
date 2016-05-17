package net.siekiera.mgc.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Klasa przechowuje informacje o elemencie wyposazenia samochodu
 */
@Entity
@Table(name = "wyposazenie")
public class ElementWyposazenia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String nazwa;

    public ElementWyposazenia() {
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
    
}
