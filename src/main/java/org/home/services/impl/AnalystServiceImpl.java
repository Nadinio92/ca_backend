package org.home.services.impl;

import lombok.RequiredArgsConstructor;
import org.home.dto.AnalystCreateOrUpdateDto;
import org.home.dto.AnalystDto;
import org.home.models.AnalystEntity;
import org.home.models.CompanyAnalystEntity;
import org.home.repository.AnalystRepository;
import org.home.repository.CompanyAnalystRepository;
import org.home.repository.CompanyRepository;
import org.home.repository.SectorRepository;
import org.home.services.AnalystService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class AnalystServiceImpl implements AnalystService {

    private final AnalystRepository analystRepository;
    private final CompanyRepository companyRepository;
    private final SectorRepository sectorRepository;
    private final CompanyAnalystRepository companyAnalystRepository;


    @Transactional
    @Override
    public Long addAnalyst(AnalystCreateOrUpdateDto dto) {
        AnalystEntity analystEntity = new AnalystEntity();
        analystEntity.setName(dto.getName());
        var savedAnalystEntity = analystRepository.save(analystEntity);

        for(Long companyId : dto.getCompanies()) {
            companyAnalystRepository.insertRelationship(companyId, analystEntity.getId());
        }

        return savedAnalystEntity.getId();
    }

    @Transactional(readOnly = true)
    @Override
    public List<AnalystDto> getAnalysts() {
        List<AnalystDto> analystDtoList = new ArrayList<>();
        for(AnalystEntity analystEntity: analystRepository.findAll()){
            AnalystDto analystDto = new AnalystDto();

            analystDto.setName(analystEntity.getName());
            analystDto.setId(analystEntity.getId());

            // companies
            List<String> companiesList = new ArrayList<>();
            for (CompanyAnalystEntity companyAnalystEntity : analystEntity.getCompanyAnalysts()) {
                String companyName = companyAnalystEntity.getCompany().getName();
                companiesList.add(companyName);
            }
            analystDto.setCompanies(companiesList);

            analystDtoList.add(analystDto);
        }
        return analystDtoList;
    }
}
