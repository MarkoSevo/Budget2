package com.biss.demo.Budget2.repository;

import com.biss.demo.Budget2.model.BudgetTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BudgetTransactionJpaRepository extends JpaRepository<BudgetTransaction, Long> {
    BudgetTransaction findBudgetTransactionById(final Long id);
}