package org.home.services;

import org.home.dto.SectorDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface SectorService {

   @Transactional
   List<SectorDto> getSectors();
}
