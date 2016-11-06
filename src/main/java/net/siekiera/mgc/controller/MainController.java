package net.siekiera.mgc.controller;

import net.siekiera.mgc.configuration.Const;
import net.siekiera.mgc.dao.*;
import net.siekiera.mgc.model.*;
import net.siekiera.mgc.service.SamochodService;
import net.siekiera.mgc.service.CurrencyService;
import net.siekiera.mgc.service.PhotoUploadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
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
    SamochodDostawczyDao samochodDostawczyDao;
    @Autowired
    SamochodBaseDao samochodBaseDao;
    @Autowired
    SamochodService samochodService;

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/login")
    public String loginPage() {
        return "login";
    }

    @RequestMapping("/czytajWaluty")
    public String czytajWaluty(RedirectAttributes redirectAttributes) {
        currencyService.updateCenyWalut();
        redirectAttributes.addFlashAttribute("message",
                "Pobralem ceny walut.");
        return "redirect:/listall";
    }

    @RequestMapping(value = "/newcar", method = RequestMethod.GET)
    public String newCar(Model model, Samochod samochod) {
        model.addAttribute("tytulFormularza", Const.TYTUL_FORM_DODAWANIE);
        model.addAttribute("samochod", new Samochod());
        model.addAttribute("allMarka", markaDao.findAll());
        model.addAttribute("allWyposazenie", wyposazenieDao.findAll());
        model.addAttribute("paliwo", Paliwo.values());
        return "addEditForm";
    }

    //to wywolujs sie przy dodawaniu nowego samochodu lub edycji
    @RequestMapping(value = "/savecar", method = RequestMethod.POST)
    public String newCarSave(@Valid Samochod samochod, BindingResult bindingResult, Model model,
                             RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("allMarka", markaDao.findAll());
            model.addAttribute("allWyposazenie", wyposazenieDao.findAll());
            return "addEditForm";
        }
        //jesli walidacja przeszla ok, to skladamy ogloszenie i zapisujemy do bazy
        List<Zdjecie> listaZdjec = photoUploadService.getZdjecieByHash(samochod.getHash());
        samochod.setZdjecia(listaZdjec);
        CenyWalut cenyWalut = currencyService.getCenyWalutFromLocalDB();
        samochod = samochodService.ustawCenyWalutoweSamochodu(samochod);
        samochodService.zapisz(samochod);
        redirectAttributes.addFlashAttribute("message",
                "Zapisano dane do bazy. [id=" + samochod.getId() + " tytuł=" + samochod.getTytul() + "]");
        return "redirect:/listall";
    }

    @RequestMapping(value = "/photoUploadJson", method = RequestMethod.POST, headers = {"Content-type=application/json"})
    public
    @ResponseBody
    String processJsonData(@RequestBody Zdjecie zdjecie) {
        log.info("Otrzymałem dane JSON (Zdjecie) id=" + zdjecie.getId() + " nazwa pliku=" + zdjecie.getNazwaPliku()
                + " hash=" + zdjecie.getHash() + " sciezka=" + zdjecie.getSciezka() + " dataUrl="
                + zdjecie.getDataUrl());
        String fileNameWithHash = photoUploadService.getFullFileNameFormFileName(zdjecie.getNazwaPliku());
        photoUploadService.saveDataUrlAsFile(zdjecie.getDataUrl(), fileNameWithHash);
        zdjecie.setSciezka(fileNameWithHash);
        photoUploadService.zapisz(zdjecie);
        //pobieranie listy zdjec po hashu:
        List<Zdjecie> listaZdjec = photoUploadService.getZdjecieByHash("bpbh5YM50s");
        return "JSON processed!";

    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String search(SamochodWzor samochodWzor, Model model, Pageable pageable, HttpSession session) {
        //taki obkeit dostaniemy z formularza
        Specification<Samochod> spec = new SamochodSpec(samochodWzor);
        if (samochodDao.findAll(spec).size() == 0) {
            model.addAttribute("errorMessage", "Zapytanie zwróciło 0 wyników!");
            model.addAttribute("samochody", null);
            model.addAttribute("allMarka", markaDao.findDistinctByMarka());
        } else {
            Page<Samochod> samochodyPage = samochodDao.findAll(spec, new PageRequest(pageable.getPageNumber(), Const.numberOfCarsPerPage));
            model.addAttribute("samochody", samochodyPage);
            model.addAttribute("allMarka", markaDao.findDistinctByMarka());
        }
        model.addAttribute("prefix", Const.PHOTO_PREFIX);
        return "listAllCars";
    }

    @RequestMapping(value = "/listall", method = RequestMethod.GET)
    public String listAll(Model model, Pageable pageable, HttpSession session) {
        List<Samochod> samochody = new ArrayList<Samochod>();
        //CenyWalut cenyWalut = currencyService.getCenyWalutFromLocalDB();
        Integer pageNumber = pageable.getPageNumber();
        Samochod samochodSearch = new Samochod();
        samochodSearch.setModel("s");
        samochodSearch.setRokProdukcji(1888);
        session.setAttribute("szukajka", samochodSearch);
        //Specification<Samochod> spec = new SamochodSpec(samochodSearch);
        //tu trzeba miec instancje ktora implementuje interfejs Specification
        //potrzebne do wyszukiwarki!
        //samochodDao.findAll(spec, new PageRequest(pageNumber, Const.numberOfCarsPerPage));
        Page<Samochod> samochodyPage = samochodDao.findAll(new PageRequest(pageNumber, Const.numberOfCarsPerPage));
        //przykład uzycia wyszukiwarki
        //Page<Samochod> samochodyPage = samochodDao.findAll(spec, new PageRequest(pageNumber, Const.numberOfCarsPerPage));
        log.info("Ilosc stron: " + samochodyPage.getTotalPages() + " Strona: " + samochodyPage.getNumber());
        model.addAttribute("prefix", Const.PHOTO_PREFIX);
        model.addAttribute("samochodWzor", new SamochodWzor());
        model.addAttribute("samochody", samochodyPage);
        model.addAttribute("allMarka", markaDao.findDistinctByMarka());
        return "listAllCars";
    }

    @RequestMapping(value = "/dostawcze", method = RequestMethod.GET)
    public String listDostawcze(Model model, Pageable pageable, HttpSession session) {
        Page<SamochodBase> samochodyPage = samochodBaseDao.findAll(new PageRequest(pageable.getPageNumber(), Const.numberOfCarsPerPage));
        model.addAttribute("samochodWzor", new SamochodWzor());
        model.addAttribute("samochody", samochodyPage);
        model.addAttribute("allMarka", markaDao.findDistinctByMarka());
        return "listAllCars";
    }

    @RequestMapping(value = "/cars/{id}", method = RequestMethod.GET)
    public String showSingleCar(@PathVariable("id") int id, Model model) {
        Samochod samochod = samochodDao.findOne(id);
        String opisHtml = new String();
        model.addAttribute("samochod", samochod);
        model.addAttribute("prefix", Const.PHOTO_PREFIX);
        //model.addAttribute("uploadPath", Const.uploadPath);
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
        model.addAttribute("tytulFormularza", Const.TYTUL_FORM_EDYCJA);
        model.addAttribute("samochod", samochod);
        model.addAttribute("allMarka", markaDao.findAll());
        model.addAttribute("allWyposazenie", wyposazenieDao.findAll());
        return "addEditForm";
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
