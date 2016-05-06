package net.siekiera.mgc.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eric on 03.05.2016.
 */
public class Testowa {
    public static void main(String[] args) {
        List<Marka> marki = new ArrayList<Marka>();
        List<ElementWyposazenia> elementyWyposazenia = new ArrayList<ElementWyposazenia>();

        List<Samochod> samochody = new ArrayList<Samochod>();

        marki.add(new Marka(1, "Audi"));
        marki.add(new Marka(2, "BMW"));
        marki.add(new Marka(3, "Mercedes"));
        elementyWyposazenia.add(new ElementWyposazenia(1, "ABS"));
        elementyWyposazenia.add(new ElementWyposazenia(1, "Wspomaganie kierownicy"));
        elementyWyposazenia.add(new ElementWyposazenia(1, "Centralny zamek"));
        elementyWyposazenia.add(new ElementWyposazenia(1, "Elektryczne szyby"));
        elementyWyposazenia.add(new ElementWyposazenia(1, "Klimatyzacja"));
        elementyWyposazenia.add(new ElementWyposazenia(1, "Światła przeciwmgielne"));

        samochody.add(new Samochod(marki.get(1), "320d", 1998, 1650, 120000, 120, elementyWyposazenia,
                12000, true, null, "Fajne auto testowe!"));
        samochody.add(new Samochod(marki.get(0), "A3 Sportback", 2010, 1998, 150000, 140, elementyWyposazenia,
                32500, true, null, "Testowe audi!"));
        System.out.println(samochody.get(0).toString());
        System.out.println(samochody.get(1).toString());
    }
    public static List<Samochod> zwrocAuto(){
        List<Marka> marki = new ArrayList<Marka>();
        List<ElementWyposazenia> elementyWyposazenia = new ArrayList<ElementWyposazenia>();

        List<Samochod> samochody = new ArrayList<Samochod>();

        marki.add(new Marka(1, "Audi"));
        marki.add(new Marka(2, "BMW"));
        marki.add(new Marka(3, "Mercedes"));
        elementyWyposazenia.add(new ElementWyposazenia(1, "ABS"));
        elementyWyposazenia.add(new ElementWyposazenia(1, "Wspomaganie kierownicy"));
        elementyWyposazenia.add(new ElementWyposazenia(1, "Centralny zamek"));
        elementyWyposazenia.add(new ElementWyposazenia(1, "Elektryczne szyby"));
        elementyWyposazenia.add(new ElementWyposazenia(1, "Klimatyzacja"));
        elementyWyposazenia.add(new ElementWyposazenia(1, "Światła przeciwmgielne"));

        samochody.add(new Samochod(marki.get(1), "320d", 1998, 1650, 120000, 120, elementyWyposazenia,
                12000, true, null, "Fajne auto testowe!"));
        samochody.add(new Samochod(marki.get(0), "A3 Sportback", 2010, 1998, 150000, 140, elementyWyposazenia,
                32500, true, null, "Testowe audi!"));
        return samochody;
    }
}
