package net.siekiera.mgc.model;

import javax.persistence.*;

/**
 * Created by eric on 16.05.2016.
 */
@Entity
@Table(name = "ceny_walut")
public class CenyWalut {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String numerTabeli;
    private String dataNotowania;
    private Double eur;
    private Double usd;

    public CenyWalut() {
    }

    public CenyWalut(Integer id, String numerTabeli, String dataNotowania, Double eur, Double usd) {
        this.id = id;
        this.numerTabeli = numerTabeli;
        this.dataNotowania = dataNotowania;
        this.eur = eur;
        this.usd = usd;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumerTabeli() {
        return numerTabeli;
    }

    public void setNumerTabeli(String numerTabeli) {
        this.numerTabeli = numerTabeli;
    }

    public String getDataNotowania() {
        return dataNotowania;
    }

    public void setDataNotowania(String dataNotowania) {
        this.dataNotowania = dataNotowania;
    }

    public Double getEur() {
        return eur;
    }

    public void setEur(Double eur) {
        this.eur = eur;
    }

    public Double getUsd() {
        return usd;
    }

    public void setUsd(Double usd) {
        this.usd = usd;
    }
}


