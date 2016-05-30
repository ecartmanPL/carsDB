package net.siekiera.mgc.controller;

import net.siekiera.mgc.dao.CenyWalutDao;
import net.siekiera.mgc.dao.MarkaDao;
import net.siekiera.mgc.dao.SamochodDao;
import net.siekiera.mgc.model.*;
import net.siekiera.mgc.service.SamochodService;
import net.siekiera.mgc.service.CurrencyService;
import net.siekiera.mgc.dao.WyposazenieDao;
import net.siekiera.mgc.service.PhotoUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@Controller
public class MainController {
    @Autowired
    CenyWalutDao cenyWalutDao;
    @Autowired
    CurrencyService currencyService;
    @Autowired
    PhotoUploadService photoUploadService;
    @Autowired
    WyposazenieDao wyposazenieDao;
    @Autowired
    MarkaDao markaDao;
    @Autowired
    SamochodDao samochodDao;
    @Autowired
    SamochodService samochodService;

    @RequestMapping("/")
    public String homePage() {
        return "homePage";
    }

    @RequestMapping(value = "/newcar", method = RequestMethod.GET)
    public String newCar(Model model) {
        model.addAttribute("samochod", new Samochod());
        model.addAttribute("allMarka", markaDao.findAll());
        model.addAttribute("allWyposazenie", wyposazenieDao.findAll());
        return "newCar";
    }

    @RequestMapping(value = "/newcar", method = RequestMethod.POST)
    public String newCarSave(@RequestParam("file") List<MultipartFile> files, @ModelAttribute Samochod samochod,
                             Model model, RedirectAttributes redirectAttributes) {
        for (MultipartFile singleFile : files) {
            if (!singleFile.isEmpty()) {
                Zdjecie zdjecie = photoUploadService.upload(singleFile);
                samochod.dodajZdjecie(zdjecie);
            }
        }
        CenyWalut cenyWalut = currencyService.getCenyWalutFromLocalDB();
        samochod = samochodService.ustawCenyWalutoweSamochodu(samochod);
        samochodService.zapisz(samochod);
        redirectAttributes.addFlashAttribute("message",
                "Zapisano dane do bazy. [id=" + samochod.getId() + " tytuł=" + samochod.getTytul() + "]");
        return "redirect:/listall";
    }

    @RequestMapping(value = "/listall", method = RequestMethod.GET)
    public String listAll(Model model, Pageable pageable) {
        List<Samochod> samochody = new ArrayList<Samochod>();
        CenyWalut cenyWalut = currencyService.getCenyWalutFromLocalDB();
        Page<Samochod> samochodyPage = samochodDao.findAll(pageable);
        // do wyjebania!
        for (Samochod samochod : samochodyPage) {
            samochod.setCenaEur(samochod.getCena() / cenyWalut.getEur());
            samochod.setCenaUsd(samochod.getCena() / cenyWalut.getUsd());
        }
        // koniec do wyjebania!
        model.addAttribute("samochody", samochodyPage);
        return "listAllCars";
    }

    @RequestMapping(value = "/cars/{id}", method = RequestMethod.GET)
    public String showSingleCar(@PathVariable("id") int id, Model model) {
        Samochod samochod = samochodDao.findOne(id);
        String opisHtml = new String();
        model.addAttribute("samochod", samochod);
        //Dodajemy HTMLowe znaki nowych linii do opisu.
        if (samochod.getOpis() != null && !samochod.getOpis().isEmpty()) {
            opisHtml = samochod.getOpis().replace("\r\n", "</br>");
            samochod.setOpis(opisHtml);
        }
        return "singleCar";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editCar(@PathVariable("id") int id, Model model) {
        Samochod samochod = samochodDao.findOne(id);
        model.addAttribute("samochod", samochod);
        model.addAttribute("allMarka", markaDao.findAll());
        model.addAttribute("allWyposazenie", wyposazenieDao.findAll());
        return "newCar";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteCar(@PathVariable("id") int id, Model model, RedirectAttributes redirectAttributes) {
        Samochod samochod = samochodDao.findOne(id);
        samochod.setListaWyposazenia(null);
        //samochod.setZdjecia(null);
        samochod.setMarka(null);
        samochodDao.delete(samochod);
        redirectAttributes.addFlashAttribute("message",
                "Usunąłem samochód z bazy. [id=" + samochod.getId() + "]");
        return "redirect:/listall";
    }
}
