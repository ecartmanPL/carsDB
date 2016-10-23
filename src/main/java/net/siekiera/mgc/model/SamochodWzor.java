package net.siekiera.mgc.model;

import java.util.Set;

/**
 * Created by Eric on 21.10.2016.
 */
public class SamochodWzor extends SamochodBase {
    private Double cenaMin;
    private Double cenaMax;
    private Set<Marka> markaList;
    private Set<Paliwo> paliwoList;

    public SamochodWzor() {
    }

    public SamochodWzor(Double cenaMin, Double cenaMax, Set<Marka> marka, Set<Paliwo> paliwo) {
        this.cenaMin = cenaMin;
        this.cenaMax = cenaMax;
        this.markaList = marka;
        this.paliwoList = paliwo;
    }

    public Double getCenaMin() {
        return cenaMin;
    }

    public void setCenaMin(Double cenaMin) {
        this.cenaMin = cenaMin;
    }

    public Double getCenaMax() {
        return cenaMax;
    }

    public void setCenaMax(Double cenaMax) {
        this.cenaMax = cenaMax;
    }

    public Set<Marka> getMarkaList() {
        return markaList;
    }

    public void setMarkaList(Set<Marka> markaList) {
        this.markaList = markaList;
    }

    public Set<Paliwo> getPaliwoList() {
        return paliwoList;
    }

    public void setPaliwoList(Set<Paliwo> paliwoList) {
        this.paliwoList = paliwoList;
    }
}
