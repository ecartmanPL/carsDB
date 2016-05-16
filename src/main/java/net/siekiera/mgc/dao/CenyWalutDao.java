package net.siekiera.mgc.dao;

import net.siekiera.mgc.model.CenyWalut;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by eric on 16.05.2016.
 */
@Transactional
public interface CenyWalutDao extends CrudRepository<CenyWalut, Integer> {

}
