package net.siekiera.mgc.service;

import net.siekiera.mgc.model.Samochod;
import net.siekiera.mgc.dao.SamochodDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by eric on 26.05.2016.
 */

@Service
public class SamochodService {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SamochodDao samochodDao;
    @Autowired
    private CurrencyService currencyService;

    public Samochod ustawCenyWalutoweSamochodu(Samochod samochod){
        samochod.setCenaEur(samochod.getCena() / currencyService.getCenyWalutFromLocalDB().getEur());
        samochod.setCenaUsd(samochod.getCena() / currencyService.getCenyWalutFromLocalDB().getUsd());
        return samochod;
    }

    public void zapisz(Samochod samochod) {
        samochodDao.save(samochod);
    }
}
