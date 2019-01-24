package com.biss.demo.Budget2.repository;

import com.biss.demo.Budget2.model.Hardware;
import com.biss.demo.Budget2.model.HardwareTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface HardwareTransactionJpaRepository extends JpaRepository<HardwareTransaction, Long> {

    @Query(value = "SELECT HARDWARE_ID\n" +
            "FROM HARDWARE_TRANSACTION\n" +
            "where HARDWARE_TRANSACTION.PERSON_ID = ?"
            , nativeQuery = true)
    List<Hardware> findAllByPersonId (final Long id);
}