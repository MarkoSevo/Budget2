package com.biss.demo.Budget2.repository;

import com.biss.demo.Budget2.model.HardwareBudgetTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HardwareBudgetTransactionRepository extends JpaRepository<HardwareBudgetTransaction, Long> {

    Long findAllByBudgetTransaction_Person_Id (Long id);
}
