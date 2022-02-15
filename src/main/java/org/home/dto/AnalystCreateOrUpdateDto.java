package org.home.dto;

import lombok.Data;

import java.util.List;
@Data
public class AnalystCreateOrUpdateDto {
    private Long id;
    private String name;
    private List<Long> companies;
}
