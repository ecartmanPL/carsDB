package net.siekiera.mgc.controller;

import net.siekiera.mgc.dao.MarkaDao;
import net.siekiera.mgc.dao.SamochodDao;
import net.siekiera.mgc.model.*;
import net.siekiera.mgc.service.CurrencyService;
import net.siekiera.mgc.dao.WyposazenieDao;
import net.siekiera.mgc.service.PhotoUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {
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
            Zdjecie zdjecie = photoUploadService.upload(singleFile);
            samochod.dodajZdjecie(zdjecie);
        }
        samochodDao.save(samochod);
        redirectAttributes.addFlashAttribute("message",
                "You successfully uploaded files!");
        return "redirect:/newcar";
    }

    @RequestMapping(value = "/listall", method = RequestMethod.GET)
    public String listAll(Model model) {
        List<Samochod> samochody = new ArrayList<Samochod>();
        for (Samochod samochod : samochodDao.findAll()) {
            samochody.add(samochod);
        }
        model.addAttribute("samochody", samochody);
        return "listAllCars";
    }
}
