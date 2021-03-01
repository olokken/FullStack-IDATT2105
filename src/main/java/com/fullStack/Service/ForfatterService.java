package com.fullStack.Service;


import com.fullStack.Entities.Forfatter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class ForfatterService {
    static ArrayList<Forfatter> forfattere = new ArrayList<>();

    public Forfatter createForfatter(Forfatter forfatter){
        forfattere.add(forfatter);
        forfatter.getBoeker().forEach(x -> {
            /*if (!BokService.boeker.contains(x)){
                BokService.boeker.add(x);
            }*/
        });
        return forfatter;
    }

    public Forfatter changeForfatter(Forfatter nyForfatterInfo, int ID) {
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
        for(int i = 0; i < forfattere.size(); i++) {
            Forfatter current = forfattere.get(i);
            if (current.getID() == ID) {
                forfattere.remove(i);
                return true;
            }
        }
        return false;
    }

    public Forfatter finnForfatterVedNavn(String navn) {
        for(int i = 0; i < forfattere.size(); i++) {
            if(forfattere.get(i).getNavn().equals(navn)){
                return forfattere.get(i);
            }
        }
        return null;
    }


    public ArrayList<Forfatter> alleForfattere() {
        return forfattere;
    }
}
