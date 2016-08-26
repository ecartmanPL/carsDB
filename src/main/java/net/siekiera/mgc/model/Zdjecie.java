package net.siekiera.mgc.model;

import org.hibernate.annotations.Type;
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
    /*
     * sciezka do pliku - to bedziemy wstawiac w htmlu w tagu <img>
     * sciezke robimy w javie
     * sciezka bedzie postaci: DSC04693_2016_08_26_LOSOWYHASH.jpg1
     */
    private String sciezka;
    //to przychodzi z JSONa - to oryginalna nazwa pliku zaladowanego przez formularz
    //dobrze byloby dodac do tego jakis hash zeby sie nie powtarzaly
    private String nazwaPliku;
    /*    to hash to pilnowania zeby zdjecia byly z jednego ogloszenia
        bedzie dodawany taki sam hash do wszystkich zdjec dodanych do tego samego ogloszenia
        hash bedzie losowany przy przeladowaniu strony i dodawany do formularza
        stamtad bedzie pobierany przez jsona i dokladany do kazdego zdjecia i tresci ogloszenia
        potem zrobimy skladanie tego do kupy*/
    private String hash;
    /*
     * data url to plik zapisany w postaci ciagu znakow. zapiszmy go tez do bazy (na wszelki wypadek).
     * zawsze bedzie mozna wylaczyc zapis tych danych, ale raczej niczego to nam nie zmieni (malo bajtow)
     */
    @Type(type="text")
    private String dataUrl;

    public String getDataUrl() {
        return dataUrl;
    }

    public void setDataUrl(String dataUrl) {
        this.dataUrl = dataUrl;
    }

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
