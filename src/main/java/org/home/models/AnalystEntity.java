package org.home.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "analyst")
@Getter
@Setter
public class AnalystEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "analyst", fetch=FetchType.LAZY)
    private Set<CompanyAnalystEntity> companyAnalysts = new HashSet<>();



}
