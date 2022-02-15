package org.home.controllers;

import lombok.RequiredArgsConstructor;
import org.home.dto.CompanyCreateOrUpdateDto;
import org.home.dto.CompanyDto;
import org.home.services.CompanyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/company")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService service;

    @GetMapping
    public List<CompanyDto> getCompanies(){
        return service.getCompanies();
    }

    @PostMapping
     Long addCompany(@RequestBody CompanyCreateOrUpdateDto company ) {
        return service.addCompany(company);
    }

    @DeleteMapping("/{id}")
    boolean deleteCompany(@PathVariable Long id) {
        return service.delete(id);
    }

}
