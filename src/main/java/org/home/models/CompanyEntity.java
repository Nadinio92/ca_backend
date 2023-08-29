package org.home.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter @Setter
@Table(name = "company")
public class CompanyEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Integer marketCap;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn (name="sector_id")
    private SectorEntity sector;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, fetch=FetchType.LAZY, orphanRemoval = true)
    private Set<CompanyAnalystEntity> companyAnalysts = new HashSet<>();

  public CompanyEntity() {
  }
}
