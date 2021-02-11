package com.fullStack.Controller;

import com.fullStack.Entities.Forfatter;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ForfatterController {

    static ArrayList<Forfatter> forfattere = new ArrayList<>();

    Logger logger = LoggerFactory.getLogger(ForfatterController.class);


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
                logger.info("Klienten søkte på forfatter ved navn: " + navn + " og søket gav resultat");
                return forfattere.get(i);
            }
        }
        logger.info("Klienten søkte på forfatter ved navn: " + navn + " og søket gav ingen resultat");
        return null;
    }

    @GetMapping("/forfattere")
    public ArrayList<Forfatter> alleForfattere() {
        logger.info("Klienten søkte på en liste over alle forfatterne");
        return forfattere;
    }
}
