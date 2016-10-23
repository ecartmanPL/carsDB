package net.siekiera.mgc.dao;

import net.siekiera.mgc.model.Samochod;
import net.siekiera.mgc.model.SamochodBase;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Eric on 23.10.2016.
 */
@Transactional
public interface SamochodBaseDao<T extends SamochodBase> extends PagingAndSortingRepository<T, Integer>, JpaSpecificationExecutor<T> {
}
