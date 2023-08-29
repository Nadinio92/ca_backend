package org.home.controllers;

import lombok.RequiredArgsConstructor;
import org.home.dto.AnalystCreateOrUpdateDto;
import org.home.dto.AnalystDto;
import org.home.services.AnalystService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/analyst")
@RequiredArgsConstructor
public class AnalystController {


    private final AnalystService service;


    @GetMapping
    public List<AnalystDto> getAnalysts() {
        return service.getAnalysts();
    }

    @PostMapping
    Long addAnalyst(@RequestBody AnalystCreateOrUpdateDto analyst) {
        return service.addAnalyst(analyst);
    }

    @DeleteMapping("/{id}")
    boolean deleteAnalyst(@PathVariable Long id) {
    return service.delete(id);
  }

    @PutMapping
    public Long updateAnalyst(@RequestBody AnalystCreateOrUpdateDto analyst){
    return service.updateAnalyst(analyst);
  }

    @GetMapping("/{id}")
    public AnalystCreateOrUpdateDto getAnalystForUpdate(@PathVariable Long id){
    return service.getAnalystForUpdate(id);
  }



}
