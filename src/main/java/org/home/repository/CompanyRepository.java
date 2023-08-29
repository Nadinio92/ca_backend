package org.home.repository;

import org.home.models.CompanyEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends CrudRepository<CompanyEntity, Long>{

    @Query("select c from CompanyEntity c " +
      "left join c.sector " +
      "left join c.companyAnalysts ca " +
      "left join ca.analyst")
    List<CompanyEntity> findAll();

    void deleteById(Long id);

}
