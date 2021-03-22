package com.fullStack.Entities;

import java.util.ArrayList;

public class Forfatter{

    private String navn;
    private int foedselsAar;
    private Adresse adresse;
    private ArrayList<Bok> boeker;
    private int ID;

    public Forfatter(String navn, int foedselsAar, Adresse adresse, ArrayList<Bok> boeker, int ID) {
        this.navn = navn;
        this.foedselsAar = foedselsAar;
        this.adresse = adresse;
        this.boeker = boeker;
        this.ID = ID;
    }

    public Forfatter(String navn, int foedselsAar, Adresse adresse, ArrayList<Bok> boeker) {
        this.navn = navn;
        this.foedselsAar = foedselsAar;
        this.adresse = adresse;
        this.boeker = boeker;
    }

    public Forfatter(){}

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

    public int getID() {return this.ID;}

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public void setID(int ID) { this.ID = ID;}
}
