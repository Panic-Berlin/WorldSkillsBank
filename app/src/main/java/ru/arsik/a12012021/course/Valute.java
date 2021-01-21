package ru.arsik.a12012021.course;

public class Valute {
    private final String numCode;
    private final String charCode;
    private final int nominal;
    private final String name;
    private final Float value;

    public Valute(String numCode, String charCode, int nominal, String name, Float value) {
        this.numCode = numCode;
        this.charCode = charCode;
        this.nominal = nominal;
        this.name = name;
        this.value = value;
    }

    public String getNumCode() {
        return numCode;
    }

    public String getCharCode() {
        return charCode;
    }

    public int getNominal() {
        return nominal;
    }

    public String getName() {
        return name;
    }

    public Float getValue() {
        return value;
    }
}
