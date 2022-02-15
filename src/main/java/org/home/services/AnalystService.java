package org.home.services;

import org.home.dto.AnalystCreateOrUpdateDto;
import org.home.dto.AnalystDto;

import java.util.List;

public interface AnalystService {

    Long addAnalyst(AnalystCreateOrUpdateDto analyst);

    List<AnalystDto> getAnalysts();
}

