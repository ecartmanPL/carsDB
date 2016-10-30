package net.siekiera.mgc.configuration;

/**
 * Created by eric on 22.05.2016.
 */
public class Const {
    public static final String test = "to jest test";
    //pamietaj o znaku "/" na koncu sciezki!
    //fizyczny folder do ktorego zapisujemy pliki
    public static final String uploadPath = "./upload/";
    //prefix do wyswietlania zdjec (zdefiniowany w StaticResourceConfiguration)
    public static final String PHOTO_PREFIX = "/photos/";
    //ilosc samochodow wyswietlana jednej stronie
    public static final Integer numberOfCarsPerPage = 4;
    //obsluga bledow walidacji formularzy
    public static final String priceNull = "Cena musi być większa od zera!";
    //tytuly formularzy
    public static final String TYTUL_FORM_EDYCJA = "Edytuj ogłoszenie";
    public static final String TYTUL_FORM_DODAWANIE = "Dodaj nowe ogłoszenie";
}