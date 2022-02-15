package org.home.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
public class CompanyAnalystId implements Serializable {

    @Column(name = "analyst_id")
    Long analystId;

    @Column(name = "company_id")
    Long companyId;

}
