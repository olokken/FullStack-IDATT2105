package com.fullStack.Service;


import com.fullStack.Entities.Bok;
import com.fullStack.Entities.Forfatter;
import com.fullStack.DAO.BokDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class BokService {
    static ArrayList<Bok> boeker = new ArrayList<>();

    @Autowired
    BokDAO repo;

    public int createBok(Bok bok) {
        boeker.add(bok);
        return repo.createBok(bok);
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
        return repo.getBoeker();
    }


    public Bok finnBokVedNavn(String navn) {
        for(int i = 0; i < boeker.size(); i++) {
            if(boeker.get(i).getNavn().equals(navn)){
                return boeker.get(i);
            }
        }
        return null;
    }

    public Bok getBok(int ISBN) {
        for(int i = 0; i < boeker.size(); i++) {
            if(boeker.get(i).getISBN() == ISBN) {
                return repo.getBok(boeker.get(i).getISBN());
            }
        }
        return null;
    }


}
