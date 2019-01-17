package com.biss.demo.Budget2.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table
public class BudgetTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonProperty("id")
    private Long id;

    @Version
    @JsonProperty("version")
    private Long version;

    @Column(name = "input_amount")
    @JsonProperty("inputAmount")
    private BigDecimal inputAmount;

    @Column(name = "output_amount")
    @JsonProperty("outputAmount")
    private BigDecimal outputAmount;

    @Column(name = "transaction_date",columnDefinition="DATE")
    @JsonProperty("transactionDate")
    private Date transactionDate;

    @ManyToOne (cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn (name = "person_id")
    private Person person;

    @ManyToMany(mappedBy = "budgetTransactionList")
    private List<Hardware> hardwareList;

}


