package com.biss.demo.Budget2.repository;

import com.biss.demo.Budget2.dto.HardwareTransactionTypeDto;
import com.biss.demo.Budget2.model.HardwareTransactionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HardwareTransactionTypeJpaRepository extends JpaRepository<HardwareTransactionType, Long> {

    HardwareTransactionType findHardwareTransactionTypeById(final Long id);
}