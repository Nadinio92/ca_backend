package org.home.controllers;

import lombok.RequiredArgsConstructor;
import org.home.dto.SectorDto;
import org.home.services.SectorService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class SectorController {

    private final SectorService sector;

    @GetMapping("/sectors")
    List<SectorDto> getSectors(){
        return sector.getSectors();
    }
}
