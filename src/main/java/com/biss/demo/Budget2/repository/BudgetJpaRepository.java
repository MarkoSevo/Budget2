package com.biss.demo.Budget2.repository;

import com.biss.demo.Budget2.model.Budget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;

@Repository
public interface BudgetJpaRepository extends JpaRepository<Budget, Long> {

   Budget findBudgetByAmount(BigDecimal amount);

   Budget findBudgetById(Long id);

   @Query(value = "SELECT SUM(INPUT_AMOUNT)-SUM(OUTPUT_AMOUNT) FROM BUDGET_TRANSACTION WHERE PERSON_ID = ?", nativeQuery = true)
   BigDecimal findRemainingAmount(Long id);
}