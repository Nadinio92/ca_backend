package org.home.services;


import org.home.dto.CompanyCreateOrUpdateDto;
import org.home.dto.CompanyDto;

import java.util.List;

public interface CompanyService {

    Long addCompany(CompanyCreateOrUpdateDto company);

    List<CompanyDto> getCompanies();

    boolean delete (Long id);
}

