package com.biss.demo.Budget2.repository;

import com.biss.demo.Budget2.model.Hardware;
import com.biss.demo.Budget2.model.HardwareTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface HardwareTransactionJpaRepository extends JpaRepository<HardwareTransaction, Long> {
    HardwareTransaction findHardwareTransactionById(final Long id);

    List<HardwareTransaction> findHardwareTransactionsByPersonId (Long id);

    //
//    @Query (value = "SELECT HARDWARE.ID, HARDWARE_TRANSACTION_TYPE.TYPE\n" +
//            "FROM HARDWARE_TRANSACTION\n" +
//            "JOIN HARDWARE\n" +
//            "ON HARDWARE.ID = HARDWARE_TRANSACTION.HARDWARE_ID\n" +
//            "JOIN PERSON\n" +
//            "ON HARDWARE_TRANSACTION.PERSON_ID = PERSON.ID\n" +
//            "JOIN HARDWARE_TRANSACTION_TYPE\n" +
//            "ON HARDWARE_TRANSACTION.HARDWARE_TRANSACTION_TYPE_ID = HARDWARE_TRANSACTION_TYPE.ID\n" +
//            "WHERE PERSON.ID = ?", nativeQuery = true)
//    List<HardwareTransaction> findHardware (Long id);
//

}