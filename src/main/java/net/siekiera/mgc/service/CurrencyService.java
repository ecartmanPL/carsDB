package net.siekiera.mgc.service;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import net.siekiera.mgc.model.CenyWalut;
import net.siekiera.mgc.model.Currency;
import net.siekiera.mgc.model.CurrencyTable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;


import org.springframework.stereotype.Service;

import javax.xml.parsers.DocumentBuilderFactory;

@Service
public class CurrencyService {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    /**
     * Method provides comlete and latest currencyTable object
     *
     * @return
     */

    public CurrencyTable getLatestTable() {
        String buySellTableName = getLatestBuySellTableUrl();
        log.info("Znalazłem adres najnowszej tabeli: {}", getLatestBuySellTableUrl());
        CurrencyTable currencyTable = new CurrencyTable();
        currencyTable.setTableNumber(getLatestTableInfo("numer_tabeli"));
        currencyTable.setPublicationDate(getLatestTableInfo("data_publikacji"));
        currencyTable.setCurrencyList(getCurrencyList());
        return currencyTable;
    }

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

    public CenyWalut getCenyWalut() {
        CenyWalut cenyWalut = new CenyWalut();
        cenyWalut.setDataNotowania(getLatestTableInfo("data_publikacji"));
        cenyWalut.setNumerTabeli(getLatestTableInfo("numer_tabeli"));
        List<Currency> currencyList = getCurrencyList();
        for (Currency currency: currencyList) {
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
            log.info("Znalazłem i zwracam tableInfo {} = {}", info, nList.item(0).getTextContent());
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
        Scanner scanner = null;
        List<String> allFileNames = new ArrayList<String>();
        try {
            URL url = new URL("http://www.nbp.pl/kursy/xml/dir.txt");
            scanner = new Scanner(url.openStream());
            while (scanner.hasNext()) {
                allFileNames.add(scanner.nextLine());
            }
        } catch (Exception e) {
            log.error("Wystąpił wyjątek przy pobieraniu listy tabel z nbp.pl");
        } finally {
            scanner.close();
        }
        StringBuilder lastLine = new StringBuilder(allFileNames.get(allFileNames.size() - 1));
        String prefix = "http://www.nbp.pl/kursy/xml/";
        lastLine.setCharAt(0, 'c');
        lastLine.append(".xml");
        return prefix + lastLine.toString();
    }

    public void test() {
        log.info("Wywołano metodę CurrencyService:test()");
    }

}