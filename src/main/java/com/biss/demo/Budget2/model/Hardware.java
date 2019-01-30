package com.biss.demo.Budget2.model;

import com.biss.demo.Budget2.dto.HardwareDetailsDto;
import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
        property  = "id",
        scope     = Long.class)
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

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "hardware_budget_transaction",
            joinColumns = @JoinColumn(name = "hardware_id"),
            inverseJoinColumns = @JoinColumn(name = "budget_transaction_id")
    )
    @JsonBackReference
    private List<BudgetTransaction> budgetTransactionList = new ArrayList<>();

    @OneToMany(
            mappedBy = "hardware",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonIgnore
    private List<HardwareTransaction> hardwareTransactionList = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "hardware_type_id")
    private HardwareType hardwareType;
}
