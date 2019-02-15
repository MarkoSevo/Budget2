package com.biss.demo.Budget2.repository;

import com.biss.demo.Budget2.model.BudgetTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.util.List;


@Repository
public interface BudgetTransactionJpaRepository extends JpaRepository<BudgetTransaction, Long> {

    BudgetTransaction findBudgetTransactionById(final Long id);

    List<BudgetTransaction> findAllByPerson_Id (final Long id);

    @Query(value = "SELECT SUM(INPUT_AMOUNT)-SUM(OUTPUT_AMOUNT) FROM BUDGET_TRANSACTION WHERE PERSON_ID = ?", nativeQuery = true)
    BigDecimal findRemainingAmount(Long id);
}