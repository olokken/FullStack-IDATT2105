package com.fullStack.Entities;

import java.util.ArrayList;

public class Forfatter{

    private String navn;
    private int foedselsAar;
    private ArrayList<Bok> boeker;
    private Adresse adresse;

    public Forfatter(String navn, int foedselsAar, ArrayList<Bok> boeker, Adresse adresse) {
        this.navn = navn;
        this.foedselsAar = foedselsAar;
        this.boeker = boeker;
        this.adresse = adresse;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public int getFoedselsAar() {
        return foedselsAar;
    }

    public void setFoedselsAar(int foedselsAar) {
        this.foedselsAar = foedselsAar;
    }

    public ArrayList<Bok> getBoeker() {
        return boeker;
    }

    public void setBoeker(ArrayList<Bok> boeker) {
        this.boeker = boeker;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }
}
