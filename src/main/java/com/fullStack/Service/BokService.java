package com.fullStack.Service;


import com.fullStack.Entities.Bok;
import com.fullStack.Entities.Forfatter;
import com.fullStack.DAO.BokDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;


@Service
public class BokService {

    @Autowired
    BokDAO repo;

    static ArrayList<Bok> boeker = new ArrayList<>();

    public void initBoeker() {
        ArrayList<Bok> repoBoeker = repo.getBoeker();
        for(int i = 0; i < repoBoeker.size(); i++) {
            if(!boeker.contains(repoBoeker.get(i))) {
                boeker.add(repoBoeker.get(i));
            }
        }
    }
    public void createBok(Bok bok) {
        initBoeker();
        boeker.add(bok);
         repo.createBok(bok);
    }

    public int changeBok(Bok nyBokInfo,int ISBN) {
        initBoeker();
        for(int i = 0; i < boeker.size(); i++) {
            Bok current = boeker.get(i);
            System.out.println(current.getNavn());
            if (current.getISBN() == ISBN) {
                boeker.set(i, nyBokInfo);
                return repo.changeBok(nyBokInfo, ISBN);
            }
        }
        return 0;
    }

    public boolean deleteBok(int ISBN) {
        initBoeker();
        for(int i = 0; i < boeker.size(); i++) {
            Bok current = boeker.get(i);
            if (current.getISBN() == ISBN) {
                boeker.remove(i);
                return repo.deleteBok(current.getISBN());
            }
        }
        return false;
    }

    public ArrayList<Bok> getBoeker() {
        initBoeker();
        return repo.getBoeker();
    }

    public ArrayList<Bok> getBoekerTest() {
        Bok bok1 = repo.tomBok();
        Bok bok2 = repo.tomBok();

        return new ArrayList<Bok>(Arrays.asList(bok1, bok2));
    }


    public Bok finnBokVedNavn(String navn) {
        initBoeker();
        for(int i = 0; i < boeker.size(); i++) {
            if(boeker.get(i).getNavn().equals(navn)){
                return repo.finnBokVedNavn(boeker.get(i).getNavn());
            }
        }
        return null;
    }

    public Bok getBok(int ISBN) {
        initBoeker();
        for(int i = 0; i < boeker.size(); i++) {
            if(boeker.get(i).getISBN() == ISBN) {
                return repo.getBok(boeker.get(i).getISBN());
            }
        }
        return null;
    }

}
