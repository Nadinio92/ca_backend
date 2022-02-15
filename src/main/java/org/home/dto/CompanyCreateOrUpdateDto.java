package org.home.dto;

import lombok.Data;

import java.util.List;

@Data
public class CompanyCreateOrUpdateDto {

    private Long id;
    private String name;
    private List<Long> analysts;
    private Integer marketCap;
    private Long sector;

}
