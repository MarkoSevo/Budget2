package com.biss.demo.Budget2.model;

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
@IdClass(value = HardwareBudgetTransaction.class)
@Table(name = "hardware_budget_transaction")
public class HardwareBudgetTransaction implements Serializable{

    @Id
    @ManyToOne
    @JoinColumn(name = "hardware_id")
    private Hardware hardware;

    @Id
    @ManyToOne
    @JoinColumn(name = "budget_transaction_id")
    private BudgetTransaction budgetTransaction;
}
