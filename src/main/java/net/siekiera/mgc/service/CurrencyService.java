package net.siekiera.mgc.service;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import net.siekiera.mgc.dao.CenyWalutDao;
import net.siekiera.mgc.dao.SamochodDao;
import net.siekiera.mgc.model.CenyWalut;
import net.siekiera.mgc.model.Currency;
import net.siekiera.mgc.model.CurrencyTable;
import net.siekiera.mgc.model.Samochod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;


import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.xml.parsers.DocumentBuilderFactory;

@Service
public class CurrencyService {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CenyWalutDao cenyWalutDao;
    @Autowired
    private SamochodDao samochodDao;

    private List<Currency> getCurrencyList() {
        List<Currency> currencyList = new ArrayList<Currency>();
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            URL url = new URL(getLatestBuySellTableUrl());
            Document document = factory.newDocumentBuilder().parse(url.openStream());
            document.getDocumentElement().normalize();
            Node nNode = null;
            NodeList nList = null;
            nList = document.getElementsByTagName("pozycja");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                String nazwa, przelicznik, kod, kupno, sprzedaz = null;
                nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Currency currency = new Currency();
                    Element element = (Element) nNode;
                    nazwa = element.getElementsByTagName("nazwa_waluty").item(0).getTextContent();
                    przelicznik = element.getElementsByTagName("przelicznik").item(0).getTextContent();
                    kod = element.getElementsByTagName("kod_waluty").item(0).getTextContent();
                    kupno = element.getElementsByTagName("kurs_kupna").item(0).getTextContent();
                    sprzedaz = element.getElementsByTagName("kurs_sprzedazy").item(0).getTextContent();
                    kupno = kupno.replace(',', '.');
                    sprzedaz = sprzedaz.replace(',', '.');
                    currency.setCurrencyName(nazwa);
                    currency.setMultiply(Integer.valueOf(przelicznik));
                    currency.setCurrencyCode(kod);
                    currency.setBuyCourse(Double.valueOf(kupno));
                    currency.setSellCourse(Double.valueOf(sprzedaz));
                    currencyList.add(currency);
                    log.info("Znalazłem i dodałem walutę {} {}. Kurs (kupno/sprzedaz) {}/{}", przelicznik, kod, kupno, sprzedaz);
                }
            }
        } catch (Exception e) {
            log.error("Wystąpił wyjątek w metodzie getCurrencyList klasy CurrencyService.");
        }
        return currencyList;
    }

    /**
     * Pobiera aktualne ceny walut z nbp i składa w obiekt
     *
     * @return
     */
    public CenyWalut getCenyWalutFromNBP() {
        CenyWalut cenyWalut = new CenyWalut();
        cenyWalut.setDataNotowania(getLatestTableInfo("data_publikacji"));
        cenyWalut.setNumerTabeli(getLatestTableInfo("numer_tabeli"));
        List<Currency> currencyList = getCurrencyList();
        for (Currency currency : currencyList) {
            if (currency.getCurrencyCode().equals("USD")) {
                cenyWalut.setUsd(currency.getSellCourse());
            }
            if (currency.getCurrencyCode().equals("EUR")) {
                cenyWalut.setEur(currency.getSellCourse());
            }
        }
        return cenyWalut;
    }

    /**
     * Pobiera najnowsze ceny walut z lokalnej bazy danych
     *
     * @return
     */
    public CenyWalut getCenyWalutFromLocalDB() {
        CenyWalut cenyWalut = cenyWalutDao.findFirstByOrderByIdDesc().get(0);
        return cenyWalut;
    }

    @Scheduled(cron = "0 15 8 * * MON-FRI")
    public void updateCenyWalut() {
        CenyWalut cenyWalut = getCenyWalutFromNBP();
        if (cenyWalut.getEur() != null && cenyWalut.getUsd() != null && cenyWalut.getDataNotowania() != null
                && cenyWalut.getNumerTabeli() != null) {
            cenyWalutDao.save(cenyWalut);
            updateAllCarsPrices();
            log.info("Zaktualizowałem ceny walut!");
        } else {
            log.error("Metoda getCenyWalutFromNBP zwrocila null! Nie zapisuje do bazy!");
        }
    }


    /**
     * Metoda aktualizuje ceny walutowe wszystkich samochodow
     */
    private void updateAllCarsPrices() {
        CenyWalut cenyWalut = getCenyWalutFromLocalDB();
        if (cenyWalut.getUsd() != null && cenyWalut.getEur() != null && cenyWalut.getDataNotowania() != null
                && cenyWalut.getNumerTabeli() != null) {
            Iterable<Samochod> samochody = samochodDao.findAll();
            for (Samochod samochod : samochody){
                samochod.setCenaEur(samochod.getCena() / cenyWalut.getEur());
                samochod.setCenaUsd(samochod.getCena() / cenyWalut.getUsd());
                samochodDao.save(samochod);
                //log.debug("Zaktualizowano cenę samochodu o id=" + samochod.getId());
            }
        }
    }

    /**
     * Method to provide table number (ex 068/C/NBP/2016) and publication date
     *
     * @param info
     * @return
     */
    private String getLatestTableInfo(String info) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            URL url = new URL(getLatestBuySellTableUrl());
            Document document = factory.newDocumentBuilder().parse(url.openStream());
            document.getDocumentElement().normalize();
            NodeList nList = null;
            nList = document.getElementsByTagName(info);
            //log.info("Znalazłem i zwracam tableInfo {} = {}", info, nList.item(0).getTextContent());
            return nList.item(0).getTextContent();
        } catch (Exception e) {
            log.error("Wystąpił wyjątek przy pobieraniu danych (getLatestTableInfo)");
            return null;
        }
    }

    /**
     * Method provides url path to latest buy/sell table (ex http://www.nbp.pl/kursy/xml/c068z160408.xml)
     *
     * @return
     */
    private String getLatestBuySellTableUrl() {
        return "http://www.nbp.pl/kursy/xml/LastC.xml";
    }

}