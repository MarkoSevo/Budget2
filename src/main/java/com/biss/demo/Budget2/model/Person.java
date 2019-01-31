package com.biss.demo.Budget2.model;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "person")
public class Person{

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
    private List<Position> positionList;

    @OneToMany(
            mappedBy = "person",
            cascade = CascadeType.PERSIST
    )
    private Set<BudgetTransaction> budgetTransactionList = new HashSet<>();

    @OneToMany(
            mappedBy = "person",
            cascade = CascadeType.PERSIST
    )
    private Set<HardwareTransaction> hardwareTransactionList = new HashSet<>();
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Person person = (Person) o;
//
//        return id != null ? id.equals(person.id) : person.id == null;
//    }
//
//    @Override
//    public int hashCode() {
//        return id != null ? id.hashCode() : 0;
//    }
}

//
//    @OneToMany(
//            mappedBy = "person",
//            cascade = CascadeType.ALL
//    )
//    private List<PersonPosition> personPositionList = new ArrayList<>();