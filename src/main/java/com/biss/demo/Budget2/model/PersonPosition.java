package com.biss.demo.Budget2.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "person_position")

public class PersonPosition implements Serializable {

    @Id
    @Column(name = "person_id")
    private Long person;

    @Id
    @Column(name = "position_id")
    private Long position;

    @Version
    @JsonProperty("Version")
    private Long version;

    @Column (name = "valid_to",columnDefinition="DATE")
    @JsonProperty ("Valid to")
    private Date validTo;

    @Column (name = "valid_from",columnDefinition="DATE")
    @JsonProperty ("Valid from")
    private Date validFrom;
}
