package net.siekiera.mgc.model;

import org.hibernate.annotations.Target;
import org.hibernate.validator.valuehandling.UnwrapValidatedValue;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Klasa przechowuje dane o ogłoszeniu sprzedaży samochodu
 */
@Entity
@Table(name = "samochody")
public class Samochod {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne(cascade = CascadeType.ALL)
    private Marka marka;
    private String model;
    private Integer rokProdukcji;
    private Integer pojemnoscSkokowa;
    private Integer przebieg;
    private Integer moc;
    @ElementCollection(targetClass = ElementWyposazenia.class)
    private List<ElementWyposazenia> wyposazenie = new ArrayList<ElementWyposazenia>();
    private Integer cena;
    private Boolean faktura;
    @ElementCollection(targetClass = Zdjecie.class)
    @OneToMany(cascade = CascadeType.ALL)
    private List<Zdjecie> zdjecia = new ArrayList<Zdjecie>();
    private String opis;


    public Samochod() {

    }

    public Samochod(int i, Samochod samochod) {
    }

    public Samochod(Marka marka, String model, Integer rokProdukcji, Integer pojemnoscSkokowa, Integer przebieg,
                    Integer moc, List<ElementWyposazenia> wyposazenie, Integer cena, Boolean faktura,
                    String opis) {
        this.marka = marka;
        this.model = model;
        this.rokProdukcji = rokProdukcji;
        this.pojemnoscSkokowa = pojemnoscSkokowa;
        this.przebieg = przebieg;
        this.moc = moc;
        this.wyposazenie = wyposazenie;
        this.cena = cena;
        this.faktura = faktura;
        this.zdjecia = zdjecia;
        this.opis = opis;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getRokProdukcji() {
        return rokProdukcji;
    }

    public void setRokProdukcji(Integer rokProdukcji) {
        this.rokProdukcji = rokProdukcji;
    }

    public Integer getPojemnoscSkokowa() {
        return pojemnoscSkokowa;
    }

    public void setPojemnoscSkokowa(Integer pojemnoscSkokowa) {
        this.pojemnoscSkokowa = pojemnoscSkokowa;
    }

    public Integer getPrzebieg() {
        return przebieg;
    }

    public void setPrzebieg(Integer przebieg) {
        this.przebieg = przebieg;
    }

    public Integer getMoc() {
        return moc;
    }

    public void setMoc(Integer moc) {
        this.moc = moc;
    }

    public Marka getMarka() {
        return marka;
    }

    public void setMarka(Marka marka) {
        this.marka = marka;
    }

    public List<ElementWyposazenia> getWyposazenie() {
        return wyposazenie;
    }

    public void setWyposazenie(List<ElementWyposazenia> wyposazenie) {
        this.wyposazenie = wyposazenie;
    }

    public Integer getCena() {
        return cena;
    }

    public void setCena(Integer cena) {
        this.cena = cena;
    }

    public Boolean getFaktura() {
        return faktura;
    }

    public void setFaktura(Boolean faktura) {
        this.faktura = faktura;
    }

    public List<Zdjecie> getZdjecia() {
        return zdjecia;
    }

    public void setZdjecia(List<Zdjecie> zdjecia) {
        this.zdjecia = zdjecia;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    @Override
    public String toString() {
        return "Samochod{" +
                "marka=" + marka +
                ", model='" + model + '\'' +
                ", rokProdukcji=" + rokProdukcji +
                ", pojemnoscSkokowa=" + pojemnoscSkokowa +
                ", przebieg=" + przebieg +
                ", moc=" + moc +
                ", wyposazenie=" + wyposazenie +
                ", cena=" + cena +
                ", faktura=" + faktura +
                //              ", zdjecia=" + zdjecia +
                ", opis='" + opis + '\'' +
                '}';
    }
}
