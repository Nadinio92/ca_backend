package org.home.services.impl;

import lombok.RequiredArgsConstructor;
import org.home.dto.SectorDto;
import org.home.models.SectorEntity;
import org.home.repository.SectorRepository;
import org.home.services.SectorService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class SectorServiceImpl implements SectorService {

    private final SectorRepository sectorRepository;

    @Override
    public List<SectorDto> getSectors() {

        List<SectorDto> sectorDtoList = new ArrayList<>();

        for (SectorEntity sectorEntity : sectorRepository.findAll()) {
            SectorDto sectorDto = new SectorDto();
            sectorDto.setId(sectorEntity.getId());
            sectorDto.setName(sectorEntity.getName());


            sectorDtoList.add(sectorDto);
        }
        return sectorDtoList;
    }
}
