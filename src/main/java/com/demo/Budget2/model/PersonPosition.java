package com.demo.Budget2.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

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
    private LocalDateTime validTo = LocalDateTime.now();

    @Column (name = "valid_from",columnDefinition="DATE")
    @JsonProperty ("Valid from")
    private LocalDateTime validFrom = LocalDateTime.now();

    @Id
    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @Id
    @ManyToOne
    @JoinColumn(name = "position_id")
    private Position position;
}
