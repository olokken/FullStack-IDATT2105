package com.fullStack.Entities;

class Adresse{
    private int postnr;
    private String by;
    private String gate;

    public Adresse(int postnr, String by, String gate) {
        this.postnr = postnr;
        this.by = by;
        this.gate = gate;
    }

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
}