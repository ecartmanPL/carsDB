package net.siekiera.currencyExchangeTables;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import net.siekiera.mgc.models.Testowa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    @Autowired
    CurrencyService currencyService;

    @RequestMapping("/test")
    public String testowaMetoda(@RequestParam(value = "name", required = false, defaultValue = "AAA Test") String name, Model model) {
        currencyService.test();
        model.addAttribute("auto", Testowa.zwrocAuto());
        return "greeting";
    }
    @RequestMapping("/listall")
    public String listAll(Model model) {
        model.addAttribute("samochody", Testowa.zwrocAuto());
        return "listall";
    }

    @RequestMapping("/table")
    public String showLatestTable(Model model) {
        CurrencyTable currencyTable = currencyService.getLatestTable();
        model.addAttribute("currencyTable", currencyTable);
        return "table";
    }
}
