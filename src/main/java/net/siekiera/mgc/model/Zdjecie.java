package net.siekiera.mgc.model;

import org.hibernate.validator.valuehandling.UnwrapValidatedValue;

import javax.persistence.*;

/**
 * Klasa przechowuje informacje o zdjęciu (sciezka)
 */
@Entity
@Table(name = "zdjecia")
public class Zdjecie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String sciezka;
    private String nazwaPliku;
    private String hash;

    public Zdjecie() {

    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public Zdjecie(String sciezka) {
        this.sciezka = sciezka;
    }

    public Zdjecie(Integer id, String sciezka) {

        this.id = id;
        this.sciezka = sciezka;
    }

    public String getNazwaPliku() {
        return nazwaPliku;
    }

    public void setNazwaPliku(String nazwaPliku) {
        this.nazwaPliku = nazwaPliku;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSciezka() {
        return sciezka;
    }

    public void setSciezka(String sciezka) {
        this.sciezka = sciezka;
    }

    @Override
    public String toString() {
        return "Zdjecie{" +
                "id=" + id +
                ", sciezka='" + sciezka + '\'' +
                '}';
    }
}
