package org.home.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Company_Analyst")
@Getter
@Setter
public class CompanyAnalystEntity {

    @EmbeddedId
    CompanyAnalystId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("analystId")
    AnalystEntity analyst;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("companyId")
    CompanyEntity company;
}
