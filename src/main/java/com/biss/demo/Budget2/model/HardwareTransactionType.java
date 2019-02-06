package com.biss.demo.Budget2.model;

import com.fasterxml.jackson.annotation.*;
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
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
public class HardwareTransactionType  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonProperty("id")
    @JsonIgnore
    private Long id;

    @Version
    @JsonProperty("version")
    @JsonIgnore
    private Long version;

    @Column(name = "type")
    @JsonProperty("type")
    private String type;

    @OneToMany(
            mappedBy = "hardwareTransactionType",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<HardwareTransaction> hardwareTransactions = new ArrayList<>();
}
