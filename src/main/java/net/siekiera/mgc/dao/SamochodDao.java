package net.siekiera.mgc.dao;

import net.siekiera.mgc.model.Samochod;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * Created by eric on 08.05.2016.
 */
@Transactional
public interface SamochodDao extends PagingAndSortingRepository<Samochod, Integer>, JpaSpecificationExecutor<Samochod> {
//    Samochod findByModel(String nazwa);
}
