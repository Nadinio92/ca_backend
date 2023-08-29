package org.home.services.impl;

import org.home.models.AnalystEntity;
import org.home.models.CompanyAnalystEntity;
import org.home.models.CompanyEntity;
import org.home.models.SectorEntity;
import org.home.repository.CompanyAnalystRepository;
import org.home.repository.CompanyRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
@SpringBootTest
class CompanyServiceImplTest {

    @Autowired
    private CompanyServiceImpl companyService;

    @MockBean
    private CompanyRepository companyRepository;

    @MockBean
    private CompanyAnalystRepository companyAnalystRepository;

    @BeforeEach
    public void setUp(){
//      companyService = new CompanyServiceImpl(companyRepository, companyAnalystRepository);
    }

    @DisplayName("JUnit test for getCompanies method")
    @Test
    void getCompaniesMethodShouldReturnAllCompanies() {

      //Analyst Entity
      AnalystEntity analystEntity1 =  new AnalystEntity();
      AnalystEntity analystEntity2 = new AnalystEntity();

      analystEntity1.setId(1L);
      analystEntity1.setName("Robert");

      analystEntity2.setId(2L);
      analystEntity2.setName("Mike");


      //Sector Entity
      SectorEntity sector1 = new SectorEntity();
      SectorEntity sector2 = new SectorEntity();
      sector1.setName("Energy");
      sector1.setId(1L);


      Set<CompanyAnalystEntity> allAnalysts = new HashSet<>();




      CompanyEntity company1 = new CompanyEntity();
      company1.setId(1L);
      company1.setName("Company1");
      company1.setSector(sector1);
      company1.setCompanyAnalysts(allAnalysts);

      Object obj = company1;

      System.out.println("Company class getName: " + obj.getClass().getName());
      System.out.println("Company class getMethods: " + obj.getClass().getMethods());


      CompanyEntity company2 = new CompanyEntity();
      company2.setId(2L);
      company2.setName("Company2");
      company2.setSector(sector1);
      company2.setCompanyAnalysts(allAnalysts);



      when(companyRepository.findAll()).thenReturn(List.of(company1,company2));

      var companyDtoList = companyService.getCompanies();

      Assertions.assertEquals(2, companyDtoList.size());

      var companyDto1 = companyDtoList.get(0);
      Assertions.assertEquals(companyDto1.getId(), 1L);
      Assertions.assertEquals(companyDto1.getName(), "Company1");

    }
}




