package net.siekiera.mgc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Eric on 01.11.2016.
 */

@Controller
public class PublicController {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/")
    public String homePage() {
        return "homePage";
    }

    //pokazuje wsyztskie samochody
    @RequestMapping("/samochody")
    public String samochody() {
        return "samochodyList";
    }

    @RequestMapping("/samochody/osobowe")
    public String samochodyOsobowe() {
        return "samochodyList";
    }

    @RequestMapping("/samochody/dostawcze")
    public String samochodyDostawcze() {
        return "samochodyList";
    }
}
