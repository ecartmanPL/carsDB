package net.siekiera.mgc.dao;

import net.siekiera.mgc.model.Zdjecie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by eric on 08.05.2016.
 */
@Transactional
public interface ZdjecieDao extends JpaRepository<Zdjecie, Integer> {
    List<Zdjecie> findByHash(String hash);
}
