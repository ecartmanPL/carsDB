package net.siekiera.mgc.model;

import net.siekiera.mgc.model.Currency;

import java.util.ArrayList;
import java.util.List;

public class CurrencyTable {
    private String tableNumber;
    private String publicationDate;
    private List<Currency> currencyList = new ArrayList<Currency>();

    public String getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(String tableNumber) {
        this.tableNumber = tableNumber;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public List<Currency> getCurrencyList() {
        return currencyList;
    }

    public void setCurrencyList(List<Currency> currencyList) {
        this.currencyList = currencyList;
    }
}
