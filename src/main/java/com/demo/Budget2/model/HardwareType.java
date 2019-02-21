package com.demo.Budget2.model;

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
@Table(name = "hardware_type")

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
            mappedBy = "hardwareType",
            fetch = FetchType.LAZY,
            cascade = CascadeType.MERGE
    )
    @JsonManagedReference
    private List<Hardware> hardwareList = new ArrayList<>();
}


