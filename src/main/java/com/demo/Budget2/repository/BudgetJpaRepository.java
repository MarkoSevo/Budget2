package com.demo.Budget2.repository;

import com.demo.Budget2.model.Budget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;

@Repository
public interface BudgetJpaRepository extends JpaRepository<Budget, Long> {

   Budget findBudgetByAmount(BigDecimal amount);

   Budget findBudgetById(Long id);

   @Query (value = "SELECT AMOUNT\n" +
           "FROM PERSON_POSITION\n" +
           "JOIN POSITION\n" +
           "ON PERSON_POSITION.POSITION_ID = POSITION.ID\n" +
           "JOIN BUDGET\n" +
           "ON BUDGET.ID = POSITION.ID\n" +
           "WHERE PERSON_POSITION.PERSON_ID = ?",nativeQuery = true)

   BigDecimal findBudgetByPosition (Long id);
}