package com.biss.demo.Budget2.repository;

import com.biss.demo.Budget2.model.BudgetPosition;
import com.biss.demo.Budget2.model.BudgetTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BudgetPositionJpaRepository extends JpaRepository<BudgetPosition, Long> {

    List<BudgetTransaction> findByPosition_Id (Long id);
}