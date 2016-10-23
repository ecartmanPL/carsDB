package net.siekiera.mgc.dao;

import net.siekiera.mgc.model.Marka;
import net.siekiera.mgc.model.Samochod;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by eric on 07.05.2016.
 */
@Transactional
public interface MarkaDao extends CrudRepository<Marka, Integer> {
    public Marka findByNazwa(String nazwa);

    @Query("SELECT DISTINCT marka FROM Samochod")
    List<Marka> findDistinctByMarka();
}
