package com.fullStack.Service;


import com.fullStack.Entities.Bok;
import com.fullStack.Entities.Forfatter;
import com.fullStack.DAO.BokDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class BokService {

    @Autowired
    BokDAO repo;

    //static ArrayList<Bok> boeker = new ArrayList<>();


    public int createBok(Bok bok) {
        //boeker.add(bok);
        return repo.createBok(bok);
    }

    public int changeBok(Bok nyBokInfo,int ISBN) {
        /*for(int i = 0; i < boeker.size(); i++) {
            Bok current = boeker.get(i);
            if (current.getISBN() == ISBN) {
                boeker.set(i, nyBokInfo);
                return repo.changeBok(nyBokInfo, ISBN);
            }
        }
        return 0;*/
        return repo.changeBok(nyBokInfo, ISBN);
    }

    public boolean deleteBok(int ISBN) {
        /*for(int i = 0; i < boeker.size(); i++) {
            Bok current = boeker.get(i);
            if (current.getISBN() == ISBN) {
                boeker.remove(i);
                return repo.deleteBok(current.getISBN());
            }
        }
        return false;*/
        return repo.deleteBok(ISBN);
    }

    public ArrayList<Bok> getBoeker() {
        return repo.getBoeker();
    }


    public Bok finnBokVedNavn(String navn) {
        /*for(int i = 0; i < boeker.size(); i++) {
            if(boeker.get(i).getNavn().equals(navn)){
                return boeker.get(i);
            }
        }
        return null;*/
        return new Bok();
    }

    public Bok getBok(int ISBN) {
        /*
        for(int i = 0; i < boeker.size(); i++) {
            if(boeker.get(i).getISBN() == ISBN) {
                return repo.getBok(boeker.get(i).getISBN());
            }
        }
        return null;*/
        return repo.getBok(ISBN);
    }

}
