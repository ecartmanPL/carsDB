package net.siekiera.mgc.controller;

import net.siekiera.mgc.dao.MarkaDao;
import net.siekiera.mgc.dao.SamochodDao;
import net.siekiera.mgc.model.*;
import net.siekiera.mgc.service.CurrencyService;
import net.siekiera.mgc.Testowa;
import net.siekiera.mgc.dao.ElementWyposazeniaDao;
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
    ElementWyposazeniaDao elementWyposazeniaDao;
    @Autowired
    MarkaDao markaDao;
    @Autowired
    SamochodDao samochodDao;

    @RequestMapping("/")
    public String homePage() {
        return "homePage";
    }

    @RequestMapping("/wypelnij")
    @ResponseBody
    public String wypelnij(String plik) {
        List<String> listaWyposazenia = Testowa.czytajPlik("/Users/eric/Desktop/wyposazenie.txt");
        ElementWyposazenia elementWyposazenia;
        for (String element : listaWyposazenia) {
            elementWyposazenia = new ElementWyposazenia(element);
            elementWyposazeniaDao.save(elementWyposazenia);
        }
        return "Done.";
    }

    @RequestMapping("/table")
    public String showLatestTable(Model model) {
        CurrencyTable currencyTable = currencyService.getLatestTable();
        model.addAttribute("currencyTable", currencyTable);
        return "table";
    }

    @RequestMapping("/newsamplecar")
    @ResponseBody
    public String create(String nazwa) {
        List<ElementWyposazenia> listaElementowWyposazenia = new ArrayList<ElementWyposazenia>();
        for (ElementWyposazenia elementWyposazenia : elementWyposazeniaDao.findAll()) {
            listaElementowWyposazenia.add(elementWyposazenia);
        }
        Marka marka = new Marka();
        marka = markaDao.findOne(2);
        List<Zdjecie> listaZdjec = new ArrayList<Zdjecie>();
        listaZdjec.add(new Zdjecie("/abc/def/ghi"));
        listaZdjec.add(new Zdjecie("jkl/mno/pqr"));
        Samochod samochod = new Samochod();
        samochod.setMarka(marka);
        samochod.setWyposazenie(listaElementowWyposazenia);
        samochod.setZdjecia(listaZdjec);
        samochod.setCena(100);
        samochod.setFaktura(true);
        samochod.setMoc(90);
        samochod.setModel("Calibra");
        samochod.setOpis("Tutaj opis pojazdu!");
        samochodDao.save(samochod);
        return "Done.";

    }


    @RequestMapping("/newmarka")
    @ResponseBody
    public String newmarka() {
        String id = "";
        try {

        } catch (Exception ex) {
            return "Blad przy tworzeniu obiektu Marka: " + ex.toString();
        }
        return "Utworzylem obiekt Marka z id= " + id;
    }

    @RequestMapping("/newwyposazenie")
    @ResponseBody
    public String newwyposazenie(String nazwa) {
        String id = "";
        try {
            ElementWyposazenia elementWyposazenia = new ElementWyposazenia(nazwa);
            elementWyposazeniaDao.save(elementWyposazenia);
            id = String.valueOf(elementWyposazenia.getId());
        } catch (Exception ex) {
            return "Blad przy tworzeniu obiektu ElementWyposazenia: " + ex.toString();
        }
        return "Utworzylem obiekt ElementWyposazenia z id= " + id;
    }

    @RequestMapping(value = "/newcar", method= RequestMethod.GET)
    public String newcar(Model model){
        model.addAttribute("samochod", new Samochod());
        return "newCar";
    }

    @RequestMapping(value="/newcar", method=RequestMethod.POST)
    public String newcarsave(@ModelAttribute Samochod samochod, Model model) {
        samochodDao.save(samochod);
        return "homePage";
    }
}
