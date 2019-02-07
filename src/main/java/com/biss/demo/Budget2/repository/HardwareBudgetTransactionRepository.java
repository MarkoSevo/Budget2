package com.biss.demo.Budget2.repository;

import com.biss.demo.Budget2.model.HardwareBudgetTransaction;
import com.biss.demo.Budget2.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HardwareBudgetTransactionRepository extends JpaRepository<HardwareBudgetTransaction, Long> {

    List<HardwareBudgetTransaction> findHardwareBudgetTransactionByBudgetTransaction_Person (Person id);

    List<HardwareBudgetTransaction> getAllByBudgetTransaction_Person_Id (Long id);

    Long findAllByBudgetTransaction_Person_Id (Long id);

    Long findAllByBudgetTransaction_PersonId (Long id);
}
