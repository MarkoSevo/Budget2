package com.biss.demo.Budget2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "hardware_budget_transaction")
public class HardwareBudgetTransaction implements Serializable{

    @Id
    @ManyToOne
    @JoinColumn(name = "hardware_id")
    @JsonIgnore
    private Hardware hardware;

    @Id
    @ManyToOne
    @JoinColumn(name = "budget_transaction_id")
    @JsonIgnore
    private BudgetTransaction budgetTransaction;

    @Version
    @JsonProperty("version")
    private Long version;
}
