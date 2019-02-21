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
@Entity
@IdClass(BudgetPosition.class)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "budget_position")
public class BudgetPosition implements Serializable {

    @Column (name = "valid_to",columnDefinition="DATE")
    @JsonProperty ("Valid to")
    private LocalDateTime validTo = LocalDateTime.now();

    @Column (name = "valid_from",columnDefinition="DATE")
    @JsonProperty ("Valid from")
    private LocalDateTime validFrom = LocalDateTime.now();

    @Id
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "budget_id")
    private Budget budget;

    @Id
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "position_id")
    private Position position;
}
