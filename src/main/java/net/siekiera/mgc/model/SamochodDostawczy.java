package net.siekiera.mgc.model;

import javax.persistence.Entity;

/**
 * Created by Eric on 23.10.2016.
 */
@Entity
public class SamochodDostawczy extends SamochodBase{
    double ladownosc;

    public SamochodDostawczy() {
    }

    public SamochodDostawczy(double ladownosc) {
        this.ladownosc = ladownosc;
    }

    public double getLadownosc() {
        return ladownosc;
    }

    public void setLadownosc(double ladownosc) {
        this.ladownosc = ladownosc;
    }
}
