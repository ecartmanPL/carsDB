package net.siekiera.mgc.controller;

import net.siekiera.mgc.dao.MarkaDao;
import net.siekiera.mgc.dao.SamochodDao;
import net.siekiera.mgc.model.*;
import net.siekiera.mgc.service.CurrencyService;
import net.siekiera.mgc.dao.WyposazenieDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {
    @Autowired
    CurrencyService currencyService;
    @Autowired
    WyposazenieDao wyposazenieDao;
    @Autowired
    MarkaDao markaDao;
    @Autowired
    SamochodDao samochodDao;

    @RequestMapping("/")
    public String homePage() {
        return "homePage";
    }

    @RequestMapping("/table")
    public String showLatestTable(Model model) {
        CurrencyTable currencyTable = currencyService.getLatestTable();
        model.addAttribute("currencyTable", currencyTable);
        return "table";
    }

    @RequestMapping(value = "/newcar", method = RequestMethod.GET)
    public String newcar(Model model) {
        model.addAttribute("samochod", new Samochod());
        model.addAttribute("allMarka", markaDao.findAll());
        model.addAttribute("allWyposazenie", wyposazenieDao.findAll());
        return "newCar";
    }

    @RequestMapping(value = "/newcar", method = RequestMethod.POST)
    public String newcarsave(@ModelAttribute Samochod samochod, Model model) {
        samochodDao.save(samochod);
        return "homePage";
    }
}
