package com.biss.demo.Budget2.repository;

import com.biss.demo.Budget2.model.Budget;
import org.springframework.data.jpa.repository.JpaRepository;
import java.math.BigDecimal;

public interface BudgetJpaRepository extends JpaRepository<Budget, Long> {

   Budget findBudgetByAmount (BigDecimal amount);
   Budget findBudgetById (Long id);
}
