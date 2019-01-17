//package com.biss.demo.Budget2.model;
//
//import com.fasterxml.jackson.annotation.JsonProperty;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.*;
//import java.util.List;
//
//
//@Data
//@Entity
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
//public class BudgetTransactionType {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "id")
//    @JsonProperty("Id")
//    private Long id;
//
//    @Version
//    @JsonProperty("Version")
//    private Long version;
//
//    @Column(name = "type")
//    @JsonProperty("Type")
//    private String type;
//
//    @OneToMany (cascade = CascadeType.ALL,
//            orphanRemoval = true)
//    @JoinColumn (name = "budget_transaction_type_id")
//    private List<BudgetTransaction> budgetTransactionList;
//}
