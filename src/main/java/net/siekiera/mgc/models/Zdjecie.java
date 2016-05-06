package net.siekiera.mgc.models;

/**
 * Klasa przechowuje informacje o zdjęciu (sciezka)
 */
public class Zdjecie {
    private Integer id;
    private String sciezka;

    public Zdjecie() {

    }

    public Zdjecie(Integer id, String sciezka) {

        this.id = id;
        this.sciezka = sciezka;
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
