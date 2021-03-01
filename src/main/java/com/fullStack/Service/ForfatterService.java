package com.fullStack.Service;


import com.fullStack.DAO.ForfatterDAO;
import com.fullStack.Entities.Forfatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class ForfatterService {

    @Autowired
    ForfatterDAO forfatterDAO;
    static ArrayList<Forfatter> forfattere = new ArrayList<>();

    /* Kan hende dette funke i stedet for å ha initForfatter i alle metodene
    public ForfatterService() {
        initForfatter();
    }*/

    private void initForfatter() {
        ArrayList<Forfatter> repoForfattere = forfatterDAO.getForfattere();
        for(int i = 0; i < repoForfattere.size(); i++) {
            if(!forfattere.contains(repoForfattere.get(i))) {
                forfattere.add(repoForfattere.get(i));
            }
        }
    }

    public Forfatter createForfatter(Forfatter forfatter){
        //initForfatter();
        forfatterDAO.createForfatter(forfatter);
        forfattere.add(forfatter);
        forfatter.getBoeker().forEach(x -> {
            if (!BokService.boeker.contains(x)){
                BokService.boeker.add(x);
            }
        });
        return forfatter;
    }

    public Forfatter changeForfatter(Forfatter nyForfatterInfo, int ID) {
        initForfatter();
        for(int i = 0; i < forfattere.size(); i++) {
            Forfatter current = forfattere.get(i);
            if (current.getID() == ID) {
                forfattere.set(i, nyForfatterInfo);
                return nyForfatterInfo;
            }
        }
        return null;
    }


    public boolean deleteForfatter(int ID) {
        initForfatter();
        for(int i = 0; i < forfattere.size(); i++) {
            Forfatter current = forfattere.get(i);
            if (current.getID() == ID) {
                forfattere.remove(i);
                return forfatterDAO.deleteForfatter(ID);
            }
        }
        return false;
    }

    public Forfatter finnForfatterVedNavn(String navn) {
        initForfatter();
        for(int i = 0; i < forfattere.size(); i++) {
            if(forfattere.get(i).getNavn().equals(navn)){
                return forfatterDAO.finnForfatterVedNavn(navn);
            }
        }
        return null;
    }


    public ArrayList<Forfatter> alleForfattere() {
        initForfatter();
        return forfatterDAO.getForfattere();
    }

    public Forfatter getForfatter(int ID) {
        initForfatter();
        for(int i = 0; i < forfattere.size(); i++) {
            if(forfattere.get(i).getID() == ID) {
                return forfatterDAO.getForfatter(ID);
            }
        }
        return null;
    }
}
