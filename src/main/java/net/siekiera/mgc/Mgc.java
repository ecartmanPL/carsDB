package net.siekiera.mgc;

import net.siekiera.mgc.dao.SamochodDao;
import net.siekiera.mgc.model.Samochod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.domain.Specification;

@SpringBootApplication
@ComponentScan("net.siekiera")
public class Mgc {

    public static void main(String[] args) {
        SpringApplication.run(Mgc.class, args);
    }

}
