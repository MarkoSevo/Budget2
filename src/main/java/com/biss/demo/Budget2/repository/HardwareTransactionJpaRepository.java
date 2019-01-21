package com.biss.demo.Budget2.repository;

import com.biss.demo.Budget2.model.HardwareTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface HardwareTransactionJpaRepository extends JpaRepository<HardwareTransaction, Long> {

    List<HardwareTransaction> findHardwareTransactionsByHardwareId (Long id);

    List<HardwareTransaction> findHardwareTransactionsByPersonId (Long id);

    HardwareTransaction findHardwareTransactionById(final Long id);

    @Query(value = "SELECT HARDWARE.ID \n" +
            "FROM HARDWARE\n" +
            "JOIN HARDWARE_TRANSACTION_TYPE\n" +
            "WHERE HARDWARE_TRANSACTION_TYPE.ID = ?\n", nativeQuery = true)
    List<HardwareTransaction> findHardwareByStatus (Long id);

    HardwareTransaction findAllByHardwareTransactionType (Long id);

}