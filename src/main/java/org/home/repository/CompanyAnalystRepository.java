package org.home.repository;

import org.home.models.CompanyAnalystEntity;
import org.home.models.CompanyAnalystId;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyAnalystRepository extends CrudRepository<CompanyAnalystEntity, CompanyAnalystId> {


    @Modifying
    @Query ("delete from CompanyAnalystEntity c where c.id.companyId = :id" )
    void deleteCompanyAnalystEntityByCompanyId(Long id);


    @Modifying
    @Query(nativeQuery = true, value = "INSERT INTO COMPANY_ANALYST(COMPANY_ID, ANALYST_ID) VALUES (:companyId, :analystId)")
    void insertRelationship(Long companyId, Long analystId);

}
