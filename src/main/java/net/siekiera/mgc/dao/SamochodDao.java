package net.siekiera.mgc.dao;

import net.siekiera.mgc.model.Samochod;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by eric on 08.05.2016.
 */
@Transactional
public interface SamochodDao extends PagingAndSortingRepository<Samochod, Integer> {
//    Samochod findByModel(String nazwa);
}
