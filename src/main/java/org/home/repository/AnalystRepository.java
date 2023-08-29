package org.home.repository;

import org.home.models.AnalystEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnalystRepository extends CrudRepository<AnalystEntity,Long> {

    List<AnalystEntity> findAnalystEntityByIdIn(List<Long> id);

    void deleteById(Long id);



}
