package net.siekiera.mgc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("net.siekiera")
public class CurrencyExchangeTablesApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyExchangeTablesApplication.class, args);
	}
}
