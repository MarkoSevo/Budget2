package com.biss.demo.Budget2.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;


@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Position")
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonProperty("id")
    private Long id;

    @Version
    @JsonProperty("version")
    private Long version;

    @Column(name = "position")
    @JsonProperty("position")
    private String position;

    @ManyToMany(mappedBy = "positionList",fetch = FetchType.LAZY)
    //@JsonManagedReference
    private List<Person> personList;

    @ManyToMany(cascade = {
            CascadeType.ALL
    })
    @JoinTable(name = "budget_position",
            joinColumns = @JoinColumn(name = "budget_id"),
            inverseJoinColumns = @JoinColumn(name = "position_id")
    )
    //@JsonManagedReference
    private List<Budget> budgetList;
}
