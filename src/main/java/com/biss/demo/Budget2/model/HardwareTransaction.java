package com.biss.demo.Budget2.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.Date;


@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "hardware_transaction")
public class HardwareTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonProperty("id")
    private Long id;

    @Version
    @JsonProperty("version")
    private Long version;

    @Column(name = "transaction_date",columnDefinition="DATE")
    @JsonProperty("transactionDate")
    private Date transactionDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    private Person person;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hardware_transaction_type_id")
    private HardwareTransactionType hardwareTransactionType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hardware_id")
    private Hardware hardware;
}
