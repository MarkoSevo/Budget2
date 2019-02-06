package com.biss.demo.Budget2.model;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.*;


@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "position")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
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
    @JsonBackReference
    private List<Person> personList = new ArrayList<>();

    @ManyToMany(mappedBy = "positionList",fetch = FetchType.LAZY)
    private List<Budget> budgetList = new ArrayList<>();
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Position position = (Position) o;
//
//        return Objects.equals(id, position.id);
//    }
//
//    @Override
//    public int hashCode() {
//        return id != null ? id.hashCode() : 0;
//    }
}

