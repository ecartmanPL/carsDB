package net.siekiera.mgc.dao;

import net.siekiera.mgc.model.Zdjecie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by eric on 08.05.2016.
 */
@Transactional
public interface ZdjecieDao extends CrudRepository<Zdjecie, Integer> {
}
