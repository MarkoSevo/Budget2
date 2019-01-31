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

    @ManyToMany(mappedBy = "positionList",fetch = FetchType.LAZY)
    private Set<Person> personList = new HashSet<>();

    @ManyToMany(mappedBy = "positionList",fetch = FetchType.LAZY)
    private Set<Budget> budgetList = new HashSet<>();

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Position position = (Position) o;
//
//        return id != null ? id.equals(position.id) : position.id == null;
//    }
//
//    @Override
//    public int hashCode() {
//        return id != null ? id.hashCode() : 0;
//    }
}

//    @OneToMany(
//            mappedBy = "position",
//            cascade = CascadeType.ALL
//    )
//    private List<PersonPosition> personPositionList = new ArrayList<>();


