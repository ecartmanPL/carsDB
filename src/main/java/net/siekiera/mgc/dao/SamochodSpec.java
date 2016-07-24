package net.siekiera.mgc.dao;

import net.siekiera.mgc.model.Samochod;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.validation.constraints.AssertFalse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by eric on 24.07.2016.
 */
public class SamochodSpec implements Specification<Samochod> {

    private final Samochod samochod;

    public SamochodSpec(Samochod samochod) {
        this.samochod = samochod;
    }

    public Predicate sprawdzModel(Root<Samochod> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        if (samochod.getModel()!=null) {
            return criteriaBuilder.equal(root.<Samochod>get("model"), samochod.getModel());
        }
        else {
            return null;
        }
    }

    public Predicate sprawdzRok(Root<Samochod> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        if (samochod.getRokProdukcji()!=null) {
            return criteriaBuilder.equal(root.<Samochod>get("rokProdukcji"), samochod.getRokProdukcji());
        }
        else {
            return null;
        }
    }

    @Override
    public Predicate toPredicate(Root<Samochod> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicateList = new ArrayList<Predicate>();
        if (StringUtils.isNotBlank(samochod.getModel())) {
            predicateList.add(criteriaBuilder.equal(root.<Samochod>get("model"), samochod.getModel()));
        }
        if (samochod.getRokProdukcji()!=null) {
            predicateList.add(criteriaBuilder.equal(root.<Samochod>get("rokProdukcji"), samochod.getRokProdukcji()));
        }
        return andTogether(predicateList, criteriaBuilder);
    }

    private Predicate andTogether(List<Predicate> predicateList, CriteriaBuilder criteriaBuilder) {
        return criteriaBuilder.and(predicateList.toArray(new Predicate[0]));
    }
}
