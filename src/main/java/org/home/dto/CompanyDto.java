package org.home.dto;

import lombok.Data;

import java.util.List;

@Data
public class CompanyDto {

    private Long id;
    private String name;
    private List<String> analysts;
    private Integer marketCap;
    private String sector;

}
