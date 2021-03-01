package com.fullStack.Entities;

public class Adresse{
    private int postnr;
    private String by;
    private String gate;
    private int ID;

    public Adresse(int postnr, String by, String gate, int ID) {
        this.postnr = postnr;
        this.by = by;
        this.gate = gate;
        this.ID = ID;
    }

    public Adresse(){}

    public int getPostnr() {
        return postnr;
    }

    public String getBy() {
        return by;
    }

    public String getGate() {
        return gate;
    }

    public void setPostnr(int postnr) {
        this.postnr = postnr;
    }

    public void setBy(String by) {
        this.by = by;
    }

    public void setGate(String gate) {
        this.gate = gate;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    private int getID() {
        return this.getID();
    }
}