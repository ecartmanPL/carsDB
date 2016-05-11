package net.siekiera.mgc.dao;

import net.siekiera.mgc.model.Marka;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by eric on 07.05.2016.
 */
@Transactional
public interface MarkaDao extends CrudRepository<Marka, Integer> {
    public Marka findByNazwa(String nazwa);
}
