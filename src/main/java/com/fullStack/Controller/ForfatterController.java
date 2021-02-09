package com.fullStack.Controller;

import com.fullStack.Entities.Forfatter;
import org.springframework.web.bind.annotation.*;

import javax.management.AttributeList;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class ForfatterController {
<<<<<<< HEAD

    ArrayList<Forfatter> forfattere = new ArrayList<>();
=======
    static ArrayList<Forfatter> forfattere = new ArrayList<>();
    Logger log = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
>>>>>>> 5331b422198992b221a343c7cb732bc38bd266a6


    @PostMapping("/forfattere")
    public Forfatter createForfatter(@RequestBody Forfatter forfatter){
        forfattere.add(forfatter);
        forfatter.getBoeker().forEach(x -> {
            if (!BokController.boeker.contains(x)){
                BokController.boeker.add(x);
            }
        });
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

    @GetMapping("/forfattere/{navn}")
    public Forfatter finnForfatterVedNavn(@PathVariable String navn) {
        for(int i = 0; i < forfattere.size(); i++) {
            if(forfattere.get(i).getNavn().equals(navn)){
                log.log(Level.ALL, "Klienten søkte etter " + navn + " og søket gav resultater");
                return forfattere.get(i);
            }
        }
        log.log(Level.ALL, "Klienten søkte etter " + navn + " og søket gav resultater");
        return null;
    }

    @GetMapping("/forfattere")
    public ArrayList<Forfatter> alleForfattere() {
        return forfattere;
    }
}
