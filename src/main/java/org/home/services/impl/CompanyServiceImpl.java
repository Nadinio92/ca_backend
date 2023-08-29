package org.home.services.impl;

import lombok.RequiredArgsConstructor;
import org.home.dto.CompanyCreateOrUpdateDto;
import org.home.dto.CompanyDto;
import org.home.exception.CompanyAnalystException;
import org.home.models.*;
import org.home.repository.CompanyAnalystRepository;
import org.home.repository.CompanyRepository;
import org.home.services.CompanyService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
@Transactional
@RequiredArgsConstructor // Creates constructor with required ('final') parameters and set fields values
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;
    private final CompanyAnalystRepository companyAnalystRepository;

    @Override
    public Long addCompany(CompanyCreateOrUpdateDto dto) {

        CompanyEntity companyEntity = new CompanyEntity();
        companyEntity.setName(dto.getName());
        companyEntity.setMarketCap(dto.getMarketCap());
        var sectorEntity = new SectorEntity();
        sectorEntity.setId(dto.getSector());
        companyEntity.setSector(sectorEntity);

        var savedCompanyEntity = companyRepository.save(companyEntity);

        List<CompanyAnalystEntity> companyAnalystEntityList = new ArrayList<>();

        for(Long analystId : dto.getAnalysts() ){
            CompanyAnalystEntity companyAnalystEntity = new CompanyAnalystEntity();
            CompanyAnalystId companyAnalystId = new CompanyAnalystId();
            companyAnalystId.setCompanyId(savedCompanyEntity.getId());
            companyAnalystId.setAnalystId(analystId);
            companyAnalystEntity.setId(companyAnalystId);

            companyAnalystEntity.setCompany(savedCompanyEntity);

            var analyst = new AnalystEntity();
            analyst.setId(analystId);
            companyAnalystEntity.setAnalyst(analyst);

            companyAnalystEntityList.add(companyAnalystEntity);
        }
        savedCompanyEntity.getCompanyAnalysts().addAll(companyAnalystEntityList);
        companyRepository.save(savedCompanyEntity);

        return savedCompanyEntity.getId();
    }



    @Transactional(readOnly = true)
    @Override
    public List<CompanyDto> getCompanies() throws CompanyAnalystException {
      var companyDtoList = new ArrayList<CompanyDto>();

      for(CompanyEntity companyEntity : companyRepository.findAll()) {
          var companyDto = new CompanyDto();
//          if (companyEntity.getId() == 2) {
//            throw new CompanyAnalystException("You have no access to company with id=" + companyEntity.getId());
//          }
          companyDto.setId(companyEntity.getId());
          companyDto.setName(companyEntity.getName());
          companyDto.setMarketCap(companyEntity.getMarketCap());
          if(companyEntity.getSector() != null) {
              companyDto.setSector(companyEntity.getSector().getName());
          }

          List<String> analystLists = new ArrayList<>();

          for(CompanyAnalystEntity companyAnalystEntity : companyEntity.getCompanyAnalysts()){
              String analystName = companyAnalystEntity.getAnalyst().getName();
              analystLists.add(analystName);
          }
          companyDto.setAnalysts(analystLists);

          companyDtoList.add(companyDto);
      }
      return companyDtoList;
    }

    @Override
    public boolean delete(Long id) {
        companyAnalystRepository.deleteCompanyAnalystEntityByCompanyId(id);
        companyRepository.deleteById(id);
        return true;
    }

    @Override
    public CompanyCreateOrUpdateDto getCompanyForUpdate(Long id) {
        var companyDto = new CompanyCreateOrUpdateDto();
        var companyEntity = companyRepository.findById(id).orElseThrow();
        companyDto.setId(companyEntity.getId());
        companyDto.setMarketCap(companyEntity.getMarketCap());
        companyDto.setName(companyEntity.getName());
        companyDto.setSector(companyEntity.getSector().getId());

        List<Long> analystLists = new ArrayList<>();
        for(CompanyAnalystEntity companyAnalystEntity : companyEntity.getCompanyAnalysts()){
            Long analystId = companyAnalystEntity.getAnalyst().getId();
            analystLists.add(analystId);
        }
        companyDto.setAnalysts(analystLists);

        return companyDto;
    }

    @Override
    public Long updateCompany(CompanyCreateOrUpdateDto dto) {

        CompanyEntity companyEntity = companyRepository.findById(dto.getId()).orElseThrow();
        companyEntity.setName(dto.getName());
        companyEntity.setMarketCap(dto.getMarketCap());
        var sectorEntity = new SectorEntity();
        sectorEntity.setId(dto.getSector());
        companyEntity.setSector(sectorEntity);

        Set<CompanyAnalystEntity> companyAnalysts = new HashSet<>();

        for(Long analystId : dto.getAnalysts()) {
            CompanyAnalystEntity companyAnalystEntity = new CompanyAnalystEntity();
            CompanyAnalystId companyAnalystId = new CompanyAnalystId();
            companyAnalystId.setCompanyId(dto.getId());
            companyAnalystId.setAnalystId(analystId);
            companyAnalystEntity.setId(companyAnalystId);

            companyAnalystEntity.setCompany(companyEntity);

            var analyst = new AnalystEntity();
            analyst.setId(analystId);
            companyAnalystEntity.setAnalyst(analyst);

            companyAnalysts.add(companyAnalystEntity);
        }
        companyEntity.getCompanyAnalysts().clear();
        companyEntity.getCompanyAnalysts().addAll(companyAnalysts);
        companyRepository.save(companyEntity);

        return dto.getId();
    }


}
