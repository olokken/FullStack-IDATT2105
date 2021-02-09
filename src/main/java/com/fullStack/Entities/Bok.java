package com.fullStack.Entities;

import java.util.ArrayList;

public class Bok{
    private String navn;
    private int ISBN;
    private int utgittAar;

    public Bok(String navn, int ISBN, int utgittAar) {
        this.navn = navn;
        this.ISBN = ISBN;
        this.utgittAar = utgittAar;
    }

    public String getNavn() {
        return navn;
    }


    public int getISBN() {
        return ISBN;
    }

    public int getUtgittAar() {
        return utgittAar;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }


    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public void setUtgittAar(int utgittAar) {
        this.utgittAar = utgittAar;
    }
}