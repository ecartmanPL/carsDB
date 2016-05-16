package net.siekiera.mgc;

import net.siekiera.mgc.dao.CenyWalutDao;
import net.siekiera.mgc.model.CenyWalut;
import net.siekiera.mgc.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import javax.annotation.PostConstruct;
import java.util.List;

@SpringBootApplication
@ComponentScan("net.siekiera")
public class CurrencyExchangeTablesApplication {
    @Autowired
    CurrencyService currencyService;
    @Autowired
    CenyWalutDao cenyWalutDao;

    public static void main(String[] args) {
        SpringApplication.run(CurrencyExchangeTablesApplication.class, args);
    }

    @PostConstruct
    public void update() {
        CenyWalut cenyWalut = currencyService.getCenyWalut();
        cenyWalutDao.save(cenyWalut);
// nie potrafie zrobic find last row!
    }
}
