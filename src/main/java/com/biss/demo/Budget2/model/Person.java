package com.biss.demo.Budget2.model;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
//
//    @OneToMany(
//            mappedBy = "person",
//            cascade = CascadeType.ALL
//    )
//    private List<PersonPosition> personPositionList = new ArrayList<>();

    @ManyToMany(cascade = {
            CascadeType.MERGE
    })
    @JoinTable(name = "person_position",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "position_id")
    )
    @Column(insertable = false, updatable = false)
    private Set<Position> positionList;

    @OneToMany(
            mappedBy = "person",
            cascade = CascadeType.MERGE,
            orphanRemoval = true
    )
    @Column(insertable = false, updatable = false)
    private Set<BudgetTransaction> budgetTransactionList = new HashSet<>();

    @OneToMany(
            mappedBy = "person",
            cascade = CascadeType.MERGE,
            orphanRemoval = true
    )
    private Set<HardwareTransaction> hardwareTransactionList = new HashSet<>();
}
