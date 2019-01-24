package com.biss.demo.Budget2.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@IdClass(BudgetPosition.class)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "budget_position")
public class BudgetPosition implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "budget_id")
    private Budget budget;

    @Id
    @ManyToOne
    @JoinColumn(name = "position_id")
    private Position position;

    @Column (name = "valid_to",columnDefinition="DATE")
    @JsonProperty ("Valid to")
    private Date validTo;

    @Column (name = "valid_from",columnDefinition="DATE")
    @JsonProperty ("Valid from")
    private Date validFrom;
}
