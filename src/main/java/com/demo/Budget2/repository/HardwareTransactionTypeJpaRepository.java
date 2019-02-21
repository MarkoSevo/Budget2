package com.demo.Budget2.repository;

import com.demo.Budget2.model.HardwareTransactionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HardwareTransactionTypeJpaRepository extends JpaRepository<HardwareTransactionType, Long> {

    HardwareTransactionType findHardwareTransactionTypeById(final Long id);
}