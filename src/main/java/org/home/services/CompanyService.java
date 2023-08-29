package org.home.services;


import org.home.dto.CompanyCreateOrUpdateDto;
import org.home.dto.CompanyDto;
import org.home.exception.CompanyAnalystException;

import java.util.List;

public interface CompanyService {

    Long addCompany(CompanyCreateOrUpdateDto company);

    List<CompanyDto> getCompanies() throws CompanyAnalystException;

    boolean delete (Long id);

    CompanyCreateOrUpdateDto getCompanyForUpdate(Long id);

    Long updateCompany(CompanyCreateOrUpdateDto company);
}

