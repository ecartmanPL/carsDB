package net.siekiera.mgc.model;

import org.springframework.web.multipart.MultipartFile;

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
    private Integer cena;
    private Boolean faktura;
    @ElementCollection(targetClass = Zdjecie.class)
    @OneToMany(cascade = CascadeType.ALL)
    private List<Zdjecie> zdjecia = new ArrayList<Zdjecie>();
    private String opis;
    @ElementCollection(targetClass = ElementWyposazenia.class)
    @OneToMany(cascade = CascadeType.ALL)
    private List<ElementWyposazenia> listaWyposazenia = new ArrayList<ElementWyposazenia>();
    @Transient
    private MultipartFile testPhoto;

    public Samochod() {
    }

    public Samochod(Integer id, Marka marka, String model, Integer rokProdukcji, Integer pojemnoscSkokowa, Integer przebieg, Integer moc, Integer cena, Boolean faktura, List<Zdjecie> zdjecia, String opis, List<ElementWyposazenia> listaWyposazenia) {
        this.id = id;
        this.marka = marka;
        this.model = model;
        this.rokProdukcji = rokProdukcji;
        this.pojemnoscSkokowa = pojemnoscSkokowa;
        this.przebieg = przebieg;
        this.moc = moc;
        this.cena = cena;
        this.faktura = faktura;
        this.zdjecia = zdjecia;
        this.opis = opis;
        this.listaWyposazenia = listaWyposazenia;
    }

    public MultipartFile getTestPhoto() {
        return testPhoto;
    }

    public void setTestPhoto(MultipartFile testPhoto) {
        this.testPhoto = testPhoto;
    }

    public List<ElementWyposazenia> getListaWyposazenia() {
        return listaWyposazenia;
    }

    public void setListaWyposazenia(List<ElementWyposazenia> listaWyposazenia) {
        this.listaWyposazenia = listaWyposazenia;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Marka getMarka() {
        return marka;
    }

    public void setMarka(Marka marka) {
        this.marka = marka;
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

    public void dodajZdjecie(Zdjecie zdjecie) {
        this.zdjecia.add(zdjecie);
    }

}
