package com.biss.demo.Budget2.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "hardware_transaction_type")
public class HardwareTransactionType  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonProperty("id")
    private Long id;

    @Version
    @JsonProperty("version")
    private Long version;

    @Column(name = "type")
    @JsonProperty("type")
    private String type;

    @OneToMany(
            mappedBy = "hardwareTransactionType",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<HardwareTransaction> comments = new ArrayList<>();

}
