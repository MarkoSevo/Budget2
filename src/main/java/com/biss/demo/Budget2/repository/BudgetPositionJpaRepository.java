package com.biss.demo.Budget2.repository;

import com.biss.demo.Budget2.model.BudgetPosition;
import com.biss.demo.Budget2.model.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;


@Repository
public interface BudgetPositionJpaRepository extends JpaRepository<BudgetPosition, Long> {

    BigDecimal findAllByPosition (Long id);

    Long findByPosition_Id (Long id);
}