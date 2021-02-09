package main.Entites;

class Adresse{
    private int postnr;
    private String by;
    private String gate;

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