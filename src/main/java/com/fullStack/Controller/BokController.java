package com.fullStack.Controller;

import com.fullStack.Entities.Bok;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

public class BokController {

    private ArrayList<Bok> boeker = new ArrayList<Bok>();

    @PostMapping("/boeker")
    public Bok createBok(@RequestBody Bok bok){
        bok.setISBN(boeker.size());
        boeker.add(bok);
        return bok;
    }

    @PutMapping("/boeker/{ISBN}")
    public Bok changeBok(@RequestBody Bok nyBokInfo, @PathVariable int ISBN) {
        for(int i = 0; i < boeker.size(); i++) {
            Bok current = boeker.get(i);
            if (current.getISBN() == ISBN) {
                boeker.set(i, nyBokInfo);
                return nyBokInfo;
            }
        }
        return null;
    }

    @DeleteMapping("/boeker/{ISBN}")
    public boolean deleteBok(@PathVariable int ISBN) {
        for(int i = 0; i < boeker.size(); i++) {
            Bok current = boeker.get(i);
            if (current.getISBN() == ISBN) {
                boeker.remove(i);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Bok> finnBokerAvForfatter(int ID) {
        ArrayList<Bok> bokerAvForfatter = new ArrayList<Bok>();
       for(int i = 0; i < boeker.size(); i++) {
           Bok current = boeker.get(i);
           for(int j = 0; j < current.getForfattere().size(); j++) {
               if(current.getForfattere().get(j).getID() == ID) {
                   bokerAvForfatter.add(current);
               }
           }
       }
       return bokerAvForfatter;
    }

}
