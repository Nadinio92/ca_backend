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
}
