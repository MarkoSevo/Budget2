package com.biss.demo.Budget2.repository;

import com.biss.demo.Budget2.model.Budget;
import com.biss.demo.Budget2.model.BudgetTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BudgetTransactionJpaRepository extends JpaRepository<BudgetTransaction, Long> {

    BudgetTransaction findBudgetTransactionById(final Long id);

    List<BudgetTransaction> findAllByPerson_Id (final Long id);
}