package com.fullStack.Controller;

import com.fullStack.Entities.Forfatter;
import com.fullStack.Service.BokService;
import com.fullStack.Service.ForfatterService;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ForfatterController {


    Logger logger = LoggerFactory.getLogger(ForfatterController.class);

    @Autowired
    private ForfatterService service;

    @PostMapping("/forfattere")
    public Forfatter createForfatter(@RequestBody Forfatter forfatter){
        logger.info("Klienten laget en ny forfatter med navn: " + forfatter.getNavn());
        return service.createForfatter(forfatter);
    }

    @PutMapping("/forfattere/{ID}")
    public Forfatter changeForfatter(@RequestBody Forfatter nyForfatterInfo, @PathVariable int ID) {
        logger.info("Klienten endret forfatter med ID: " + ID);
        return service.changeForfatter(nyForfatterInfo,ID);
    }

    @DeleteMapping("/forfattere/{ID}")
    public boolean deleteForfatter(@PathVariable int ID) {
        logger.info("Klientet slettet forfatter med ID: " + ID);
        return service.deleteForfatter(ID);
    }

    @GetMapping("/forfattere/navn/{navn}")
    public Forfatter finnForfatterVedNavn(@PathVariable String navn) {
        logger.info("Klienten søkte etter forfatteren " + navn);
        return service.finnForfatterVedNavn(navn);
    }

    @GetMapping("/forfattere/id/{ID}")
    public Forfatter getForfatter(@PathVariable int ID) {
        logger.info("Klienten søkte etter forfatteren med ID " + ID);
        return service.getForfatter(ID);
    }

    @GetMapping("/forfattere")
    public ArrayList<Forfatter> alleForfattere() {
        logger.info("Klienten søkte på en liste over alle forfatterne");
        return service.alleForfattere();
    }
}
