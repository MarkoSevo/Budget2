package com.biss.demo.Budget2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "position")
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

    @ManyToMany(mappedBy = "positionList")
    @JsonIgnore
    private Set<Person> personList = new HashSet<>();

    @ManyToMany(mappedBy = "positionList")
    @JsonIgnore
    private Set<Budget> budgetList = new HashSet<>();
}

//    @OneToMany(
//            mappedBy = "position",
//            cascade = CascadeType.ALL
//    )
//    private List<PersonPosition> personPositionList = new ArrayList<>();


