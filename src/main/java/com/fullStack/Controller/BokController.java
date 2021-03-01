package com.fullStack.Controller;

import com.fullStack.Entities.Bok;
import com.fullStack.Service.BokService;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
public class BokController {

    Logger logger = LoggerFactory.getLogger(BokController.class);

    @Autowired
    private BokService service;

    @PostMapping("/boeker")
    public int createBok(@RequestBody Bok bok) {
        return service.createBok(bok);
    }

    @PutMapping("/boeker/{ISBN}")
    public Bok changeBok(@RequestBody Bok nyBokInfo, @PathVariable int ISBN) {
            return service.changeBok(nyBokInfo, ISBN);
    }

    @DeleteMapping("/boeker/{ISBN}")
    public boolean deleteBok(@PathVariable int ISBN) {
        return service.deleteBok(ISBN);
    }

    @GetMapping("/boeker")
    public ArrayList<Bok> getBoeker() {
        logger.info("Klienten søkte etter alle bøkene");
        return service.getBoeker();
    }

    @GetMapping("/boeker/{navn}")
    public Bok finnBokVedNavn(@PathVariable String navn) {
        logger.info("Klienten søkte etter " + navn);
        return service.finnBokVedNavn(navn);
    }

    @GetMapping("/boeker/{ISBN}")
    public Bok getBok(@RequestParam int ISBN) {
        logger.info("Klienten søkte etter bok med ISBN: " + ISBN);
        return service.getBok(ISBN);
    }
}
