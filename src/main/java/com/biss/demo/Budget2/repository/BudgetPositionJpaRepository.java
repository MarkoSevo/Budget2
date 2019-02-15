package com.biss.demo.Budget2.repository;

import com.biss.demo.Budget2.model.BudgetPosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BudgetPositionJpaRepository extends JpaRepository<BudgetPosition, Long> {

}