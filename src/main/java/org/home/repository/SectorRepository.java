package org.home.repository;

import org.home.models.SectorEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SectorRepository extends CrudRepository<SectorEntity, Long> {

    List<SectorEntity>findAll();
}
