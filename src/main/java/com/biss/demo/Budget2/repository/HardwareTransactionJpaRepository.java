package com.biss.demo.Budget2.repository;

import com.biss.demo.Budget2.model.HardwareTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HardwareTransactionJpaRepository extends JpaRepository<HardwareTransaction, Long> {
    HardwareTransaction findHardwareTransactionById(final Long id);

    List<HardwareTransaction> findHardwareTransactionByPersonId (Long id);
}