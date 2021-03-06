package net.siekiera.mgc.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Eric on 23.10.2016.
 */
@Entity
@Inheritance
public abstract class SamochodBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne(cascade = CascadeType.ALL)
    @NotNull
    private Marka marka;
    @NotNull
    @Size(min=1)
    private String model;
    @NotNull
    @Size(min=1)
    private String tytul;
    @Min(0)
    private Integer rokProdukcji;
    @Min(0)
    private Integer pojemnoscSkokowa;
    @Min(0)
    private Integer przebieg;
    @Min(0)
    private Integer moc;
    @NotNull
    @Min(0)
    private Double cena;
    private Double cenaUsd;
    private Double cenaEur;
    private Boolean faktura;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Zdjecie> zdjecia = new ArrayList<Zdjecie>();
    @Lob
    @Column(name="opis", length=512)
    private String opis;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<ElementWyposazenia> listaWyposazenia = new ArrayList<ElementWyposazenia>();
    private String hash;
    private Paliwo paliwo;

    public SamochodBase() {
    }

    public SamochodBase(Integer id, Marka marka, String model, String tytul, Integer rokProdukcji, Integer pojemnoscSkokowa, Integer przebieg, Integer moc, Double cena, Double cenaUsd, Double cenaEur, Boolean faktura, List<Zdjecie> zdjecia, String opis, List<ElementWyposazenia> listaWyposazenia, String hash, Paliwo paliwo) {
        this.id = id;
        this.marka = marka;
        this.model = model;
        this.tytul = tytul;
        this.rokProdukcji = rokProdukcji;
        this.pojemnoscSkokowa = pojemnoscSkokowa;
        this.przebieg = przebieg;
        this.moc = moc;
        this.cena = cena;
        this.cenaUsd = cenaUsd;
        this.cenaEur = cenaEur;
        this.faktura = faktura;
        this.zdjecia = zdjecia;
        this.opis = opis;
        this.listaWyposazenia = listaWyposazenia;
        this.hash = hash;
        this.paliwo = paliwo;
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

    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
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

    public Double getCena() {
        return cena;
    }

    public void setCena(Double cena) {
        this.cena = cena;
    }

    public Double getCenaUsd() {
        return cenaUsd;
    }

    public void setCenaUsd(Double cenaUsd) {
        this.cenaUsd = cenaUsd;
    }

    public Double getCenaEur() {
        return cenaEur;
    }

    public void setCenaEur(Double cenaEur) {
        this.cenaEur = cenaEur;
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

    public List<ElementWyposazenia> getListaWyposazenia() {
        return listaWyposazenia;
    }

    public void setListaWyposazenia(List<ElementWyposazenia> listaWyposazenia) {
        this.listaWyposazenia = listaWyposazenia;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public Paliwo getPaliwo() {
        return paliwo;
    }

    public void setPaliwo(Paliwo paliwo) {
        this.paliwo = paliwo;
    }
}
