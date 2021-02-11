package com.fullStack.Controller;

import com.fullStack.Entities.Bok;
import com.fullStack.Entities.Forfatter;
import com.fullStack.Services.BokService;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
public class BokController {

    static ArrayList<Bok> boeker = new ArrayList<>();

    Logger logger = LoggerFactory.getLogger(BokController.class);

    @Autowired
    private BokService service ;

    @PostMapping("/boeker")
    public Bok createBok(@RequestBody Bok bok) {
        boeker.add(bok);
        return bok;
    }

    @PutMapping("/boeker/{ISBN}")
    public Bok changeBok(@RequestBody Bok nyBokInfo, @PathVariable int ISBN) {
        for(int i = 0; i < boeker.size(); i++) {
            Bok current = boeker.get(i);
            if (current.getISBN() == ISBN) {
                boeker.set(i, nyBokInfo);
                break;
            }
        }
        for(Forfatter f: ForfatterController.forfattere){
            for (Bok b : f.getBoeker()) {
                if(b.getISBN() == ISBN) {
                    f.getBoeker().remove(b);
                    f.getBoeker().add(nyBokInfo);
                }
            }
        }
        return nyBokInfo;
    }

    @DeleteMapping("/boeker/{ISBN}")
    public boolean deleteBok(@PathVariable int ISBN) {
        for(Forfatter f: ForfatterController.forfattere){
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

    @GetMapping("/boeker")
    public ArrayList<Bok> getBoeker() {
        logger.info("Klienten søkte etter alle bøkene");
        return boeker;
    }


    @GetMapping("/boeker/{navn}")
    public Bok finnBokVedNavn(@PathVariable String navn) {
        for(int i = 0; i < boeker.size(); i++) {
            if(boeker.get(i).getNavn().equals(navn)){
                logger.info("Klienten søkte etter " + navn + " og søket gav resultater");
                return boeker.get(i);
            }
        }
        logger.info("Klienten søkte etter " + navn + " og søket gav ingen resultater");
        return null;
    }

    @RequestMapping("/boeker/{navn}")
    public Bok message() {
        logger.trace("En Trace");
        logger.debug("En Debug");
        logger.info("En info");
        logger.warn("En advarsel");
        logger.error("En error");
        return this.service.melding();
    }
}
