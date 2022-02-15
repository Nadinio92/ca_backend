package org.home.dto;

import lombok.Data;

import java.util.List;

@Data
public class AnalystDto {

    private Long id;
    private String name;
    private List<String> companies;
}
