package net.siekiera.mgc.models;

/**
 * Klasa przechowuje informacje o elemencie wyposażenia (np ABS, Elektryczne szyby)
 */
public class ElementWyposazenia {
    Integer id;
    String nazwa;

    public ElementWyposazenia() {
    }

    public ElementWyposazenia(Integer id, String nazwa) {
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
        return "ElementWyposazenia{" +
                "id=" + id +
                ", nazwa='" + nazwa + '\'' +
                '}';
    }
}
