package net.siekiera.mgc.models;

/**
 * Klasa przechowuje informacje o marce (VW, Audi, Mercedes etc)
 */
public class Marka {
    private Integer id;
    private String nazwa;

    public Marka() {
    }

    public Marka(Integer id, String nazwa) {
        this.id = id;
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
