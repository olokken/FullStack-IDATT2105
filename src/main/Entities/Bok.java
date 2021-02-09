package main.Entites;

import java.util.ArrayList;

public class Bok{

    private String navn;
    private ArrayList<Forfatter> forfattere;
    private String ISBN;
    private int utgittAar;

    public Bok(String navn, ArrayList<Forfatter> forfattere, String ISBN, int utgittAar) {
        this.navn = navn;
        this.forfattere = forfattere;
        this.ISBN = ISBN;
        this.utgittAar = utgittAar;
    }

    public String getNavn() {
        return navn;
    }

    public ArrayList<Forfatter> getForfattere() {
        return forfattere;
    }

    public String getISBN() {
        return ISBN;
    }

    public int getUtgittAar() {
        return utgittAar;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public void setForfattere(ArrayList<Forfatter> forfattere) {
        this.forfattere = forfattere;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setUtgittAar(int utgittAar) {
        this.utgittAar = utgittAar;
    }
}