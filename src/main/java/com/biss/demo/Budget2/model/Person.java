package com.biss.demo.Budget2.model;

import com.fasterxml.jackson.annotation.*;
import lombok.*;
import javax.persistence.*;
import java.util.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
@Table(name = "person")

public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonProperty("id")
    private Long id;

    @Version
    @JsonProperty("version")
    private Long version;

    @Column(name = "first_name")
    @JsonProperty("firstName")
    private String firstName;

    @Column(name = "last_name")
    @JsonProperty("lastName")
    private String lastName;

    @Column(name = "email")
    @JsonProperty("email")
    private String email;

    @Column(name = "username")
    @JsonProperty("userName")
    private String userName;

    @ManyToMany(cascade = {
            CascadeType.MERGE,
            CascadeType.PERSIST
    })
    @JoinTable(name = "person_position",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "position_id")
    )
    private List<Position> positionList = new ArrayList<>();

    @OneToMany(
            mappedBy = "person",
            cascade = CascadeType.PERSIST,
            fetch = FetchType.LAZY
    )
    private List<BudgetTransaction> budgetTransactionList = new ArrayList<>();

    @OneToMany(
            mappedBy = "person",
            cascade = CascadeType.PERSIST,
            fetch = FetchType.LAZY
    )
    private List<HardwareTransaction> hardwareTransactionList = new ArrayList<>();
}
