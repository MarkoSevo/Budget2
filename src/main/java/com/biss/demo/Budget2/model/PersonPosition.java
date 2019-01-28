package com.biss.demo.Budget2.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serializable;
import java.lang.reflect.Member;
import java.util.Date;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@IdClass(value = PersonPosition.class)
@Table(name = "person_position")
public class PersonPosition implements Serializable {

    @Column (name = "valid_to",columnDefinition="DATE")
    @JsonProperty ("Valid to")
    private Date validTo;

    @Column (name = "valid_from",columnDefinition="DATE")
    @JsonProperty ("Valid from")
    private Date validFrom;

    @Id
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "person_id")
    private Person person;

    @Id
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "position_id")
    private Position position;
}

//    @Id
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn (name = "person_id")
//    private Person person;
//
//    @Id
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn (name = "position_id")
//    private Position position;