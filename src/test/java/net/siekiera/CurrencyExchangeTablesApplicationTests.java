package net.siekiera;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import net.siekiera.mgc.CurrencyExchangeTablesApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = CurrencyExchangeTablesApplication.class)
@WebAppConfiguration
public class CurrencyExchangeTablesApplicationTests {

	@Test
	public void contextLoads() {
	}

}
