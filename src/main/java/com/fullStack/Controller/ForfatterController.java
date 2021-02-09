package com.fullStack.Controller;

import com.fullStack.Entities.Bok;
import com.fullStack.Entities.Forfatter;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

public class ForfatterController {
    ArrayList<Forfatter> forfattere = new ArrayList<Forfatter>();

    @PostMapping("/forfattere")
    public Forfatter createForfatter(@RequestBody Forfatter forfatter){
        forfattere.add(forfatter);
        return forfatter;
    }

    @PutMapping("/forfattere/{ID}")
    public Forfatter changeBok(@RequestBody Forfatter nyForfatterInfo, @PathVariable int ID) {
        for(int i = 0; i < forfattere.size(); i++) {
            Forfatter current = forfattere.get(i);
            if (current.getID() == ID) {
                forfattere.set(i, nyForfatterInfo);
                return nyForfatterInfo;
            }
        }
        return null;
    }

    @DeleteMapping("/forfattere/{ID}")
    public boolean deleteForfatter(@PathVariable int ID) {
        for(int i = 0; i < forfattere.size(); i++) {
            Forfatter current = forfattere.get(i);
            if (current.getID() == ID) {
                forfattere.remove(i);
                return true;
            }
        }
        return false;
    }

    @GetMapping
    public Forfatter finnForfatterVedNavn(@PathVariable String navn) {
        for(int i = 0; i < forfattere.size(); i++) {
            if(forfattere.get(i).getNavn().equals(navn)){
                return forfattere.get(i);
            }
        }
        return null;
    }
}
