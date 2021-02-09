package com.fullStack.Controller;

import com.fullStack.Entities.Bok;
import com.fullStack.Entities.Forfatter;
import org.springframework.web.bind.annotation.*;
import com.fullStack.Controller.BokController;

import javax.management.AttributeList;
import java.util.ArrayList;

@RestController
public class ForfatterController {
    ArrayList<Forfatter> forfattere = new ArrayList<>();
    BokController boeker;

    @PostMapping("/forfattere")
    public Forfatter createForfatter(@RequestBody Forfatter forfatter){
        forfattere.add(forfatter);
        for(int i = 0; i < forfatter.getBoeker().size(); i++) {
            
        }
        return forfatter;
    }

    @PutMapping("/forfattere/{ID}")
    public Forfatter changeBok(@RequestBody Forfatter nyForfatterInfo, @PathVariable int ID) {
        for(int i = 0; i < forfattere.size(); i++) {
            Forfatter current = forfattere.get(i);
            if (current.getID() == ID) {
                for(int j = 0; j < current.getBoeker().size(); j++) {
                    if(current.getBoeker().get(j))
                }
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

    @GetMapping("/forfattere/{navn}")
    public Forfatter finnForfatterVedNavn(@PathVariable String navn) {
        for(int i = 0; i < forfattere.size(); i++) {
            if(forfattere.get(i).getNavn().equals(navn)){
                return forfattere.get(i);
            }
        }
        return null;
    }

    @GetMapping("/forfattere")
    public ArrayList<Forfatter> alleForfattere() {
        return forfattere;
    }
}
