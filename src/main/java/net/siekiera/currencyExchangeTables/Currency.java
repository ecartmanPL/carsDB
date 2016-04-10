package net.siekiera.currencyExchangeTables;

public class Currency {
    private String currencyName;
    private String currencyCode;
    private int multiply;
    private double buyCourse;
    private double sellCourse;

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public int getMultiply() {
        return multiply;
    }

    public void setMultiply(int multiply) {
        this.multiply = multiply;
    }

    public double getBuyCourse() {
        return buyCourse;
    }

    public void setBuyCourse(double buyCourse) {
        this.buyCourse = buyCourse;
    }

    public double getSellCourse() {
        return sellCourse;
    }

    public void setSellCourse(double sellCourse) {
        this.sellCourse = sellCourse;
    }
}
