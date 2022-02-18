package org.home.repository;

import org.home.models.CompanyEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends CrudRepository<CompanyEntity, Long>{

    List<CompanyEntity> findAll();

    void deleteById(Long id);

}
