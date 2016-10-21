package net.siekiera.mgc.dao;

import net.siekiera.mgc.model.Samochod;
import net.siekiera.mgc.model.SamochodWzor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import javax.validation.constraints.AssertFalse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by eric on 24.07.2016.
 */
public class SamochodSpec implements Specification<Samochod> {

    private final SamochodWzor samochod;

    public SamochodSpec(SamochodWzor samochod) {
        this.samochod = samochod;
    }
//
//    public Predicate sprawdzModel(Root<Samochod> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
//        if (samochod.getModel() != null) {
//            return criteriaBuilder.equal(root.<Samochod>get("model"), samochod.getModel());
//        } else {
//            return null;
//        }
//    }
//
//    public Predicate sprawdzCene(Root<Samochod> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
//
//        //ParameterExpression<Double> value = criteriaBuilder.parameter(Double.class);
//        if (samochod.getCena() != null) {
//
//        } else {
//            return null;
//        }
//    }

    public Predicate sprawdzRok(Root<Samochod> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        if (samochod.getRokProdukcji() != null) {
            return criteriaBuilder.equal(root.<Samochod>get("rokProdukcji"), samochod.getRokProdukcji());
        } else {
            return null;
        }
    }

    @Override
    public Predicate toPredicate(Root<Samochod> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicateList = new ArrayList<Predicate>();
        CriteriaQuery<Samochod> query = criteriaBuilder.createQuery(Samochod.class);
        Root<Samochod> samochodRoot = query.from(Samochod.class);

        if (samochod.getCenaMin() != null) {
            predicateList.add(criteriaBuilder.greaterThan(root.get("cena"), samochod.getCenaMin()));
        }

        if (samochod.getCenaMax() != null) {
            predicateList.add(criteriaBuilder.lessThan(root.get("cena"), samochod.getCenaMax()));
        }
//        if (samochod.getRokProdukcji() != null) {
//            predicateList.add(criteriaBuilder.equal(root.<Samochod>get("rokProdukcji"), samochod.getRokProdukcji()));
//        }
        return andTogether(predicateList, criteriaBuilder);
    }

    private Predicate andTogether(List<Predicate> predicateList, CriteriaBuilder criteriaBuilder) {
        return criteriaBuilder.and(predicateList.toArray(new Predicate[0]));
    }
}
