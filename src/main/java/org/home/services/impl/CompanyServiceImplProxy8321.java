package org.home.services.impl;

import org.home.repository.AnalystRepository;
import org.home.repository.CompanyAnalystRepository;
import org.home.repository.CompanyRepository;
import org.home.repository.SectorRepository;

public class CompanyServiceImplProxy8321 extends CompanyServiceImpl {
    public CompanyServiceImplProxy8321(CompanyRepository companyRepository, AnalystRepository analystRepository, SectorRepository sectorRepository, CompanyAnalystRepository companyAnalystRepository) {
        super(companyRepository, analystRepository, sectorRepository, companyAnalystRepository);
    }
/*
    @Override
    public Long addCompany(CompanyCreateOrUpdateDto dto) {
        var transaction = SpringTransactionManager.openTransaction();
        try {
            var result = super.addCompany(dto);
            SpringTransactionManager.commit();
        } catch (Exception e) {
            transaction.rollback();
        }

    }

 */
}
