package com.biss.demo.Budget2.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
@Table(name = "hardware_type")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
        property  = "id",
        scope     = Long.class)
public class HardwareType {

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
            mappedBy = "hardwareType",fetch = FetchType.EAGER,
            cascade = CascadeType.MERGE
    )
    @JsonBackReference
    private List<Hardware> hardwareList = new ArrayList<>();
}


