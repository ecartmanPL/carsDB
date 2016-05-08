package net.siekiera.mgc.dao;

import net.siekiera.mgc.model.Samochod;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by eric on 08.05.2016.
 */
@Transactional
public interface SamochodDao extends CrudRepository<Samochod, Integer> {
    public Samochod findByModel(String nazwa);
}
