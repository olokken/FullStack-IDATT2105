package com.fullStack.Entities;

import java.util.ArrayList;

public class Forfatter{

    private String navn;
    private int foedselsAar;
    private Adresse adresse;
    private int ID;

    public Forfatter(String navn, int foedselsAar, Adresse adresse, int ID) {
        this.navn = navn;
        this.foedselsAar = foedselsAar;
        this.adresse = adresse;
        this.ID = ID;
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

    public Adresse getAdresse() {
        return adresse;
    }

    public int getID() {return this.ID;}

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public void setID(int ID) { this.ID = ID;}
}
