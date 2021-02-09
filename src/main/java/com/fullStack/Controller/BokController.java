package com.fullStack.Controller;

import com.fullStack.Entities.Bok;
import com.fullStack.Entities.Forfatter;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class BokController {
    static ArrayList<Bok> boeker = new ArrayList<>();
    Logger log = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

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

    @GetMapping("/boeker")
    public ArrayList<Bok> getBoeker() {
        return boeker;
    }


    @GetMapping("/boeker/{navn}")
    public Bok finnBokVedNavn(@PathVariable String navn) {
        for(int i = 0; i < boeker.size(); i++) {
            if(boeker.get(i).getNavn().equals(navn)){
                log.log(Level.ALL, "Klienten søkte etter " + navn + " og søket gav resultater");
                return boeker.get(i);
            }
        }
        log.log(Level.ALL, "Klienten søkte etter " + navn + " og søket gav resultater");
        return null;
    }


}
