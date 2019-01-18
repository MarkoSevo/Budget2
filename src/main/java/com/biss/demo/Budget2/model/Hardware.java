package com.biss.demo.Budget2.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
public class Hardware {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonProperty("id")
    private Long id;

    @Version
    @JsonProperty("version")
    private Long version;

    @Column(name = "serial_number")
    @JsonProperty("serialNumber")
    private Long serialNumber;

    @Column(name = "price")
    @JsonProperty("price")
    private BigDecimal price;

    @Column(name = "purchase_date",columnDefinition="DATE")
    @JsonProperty("purchaseDate")
    private Date purchaseDate;

    @ManyToOne (cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn (name = "hardware_type_id")
    private HardwareType hardwareType;

    @ManyToMany(cascade = {
            CascadeType.ALL
    })
    @JoinTable(name = "hardware_budget_transaction",
            joinColumns = @JoinColumn(name = "hardware_id"),
            inverseJoinColumns = @JoinColumn(name = "budget_transaction_id")
    )
    //@JsonManagedReference
    private List<BudgetTransaction> budgetTransactionList;
}
