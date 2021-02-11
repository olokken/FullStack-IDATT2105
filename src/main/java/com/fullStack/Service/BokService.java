package com.fullStack.Service;


import com.fullStack.Entities.Bok;
import com.fullStack.Entities.Forfatter;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@Service
public class BokService {
    static ArrayList<Bok> boeker = new ArrayList<>();

    public Bok createBok(Bok bok) {
        boeker.add(bok);
        return bok;
    }

    public Bok changeBok(Bok nyBokInfo,int ISBN) {
        for(int i = 0; i < boeker.size(); i++) {
            Bok current = boeker.get(i);
            if (current.getISBN() == ISBN) {
                boeker.set(i, nyBokInfo);
                break;
            }
        }
        for(Forfatter f: ForfatterService.forfattere){
            for (Bok b : f.getBoeker()) {
                if(b.getISBN() == ISBN) {
                    f.getBoeker().remove(b);
                    f.getBoeker().add(nyBokInfo);
                }
            }
        }
        return nyBokInfo;
    }

    public boolean deleteBok(int ISBN) {
        for(Forfatter f: ForfatterService.forfattere){
            for (Bok b : f.getBoeker()) {
                if(b.getISBN() == ISBN) {
                    f.getBoeker().remove(b);
                    break;
                }
            }
        }
        for(int i = 0; i < boeker.size(); i++) {
            Bok current = boeker.get(i);
            if (current.getISBN() == ISBN) {
                boeker.remove(i);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Bok> getBoeker() {
        return boeker;
    }


    @GetMapping("/boeker/{navn}")
    public Bok finnBokVedNavn(String navn) {
        for(int i = 0; i < boeker.size(); i++) {
            if(boeker.get(i).getNavn().equals(navn)){
                return boeker.get(i);
            }
        }
        return null;
    }


}
