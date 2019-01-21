package com.biss.demo.Budget2.repository;

import com.biss.demo.Budget2.model.Hardware;
import com.biss.demo.Budget2.model.HardwareTransactionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Date;
import java.util.List;

@Repository
public interface HardwareJpaRepository extends JpaRepository<Hardware, Long> {
    Hardware findHardwareById(final Long id);
    Hardware findHardwareBySerialNumber (final Long serial);
    List<Hardware> findHardwareByPurchaseDate (final Date purchaseDate);
    List<Hardware> findAllByHardwareType (final Long hardwareType);



    @Query(value = "SELECT HARDWARE_ID, HARDWARE_TRANSACTION_TYPE_ID\n" +
            "FROM HARDWARE_TRANSACTION\n" +
            "WHERE HARDWARE_ID = ?",nativeQuery = true)
    List<HardwareTransactionType> findAllByStatus(Long id);
//
//    @Query(value = "SELECT HARDWARE_ID, HARDWARE_TRANSACTION_TYPE_ID FROM HARDWARE_TRANSACTION\n" +
//            "JOIN PERSON P on HARDWARE_TRANSACTION.PERSON_ID = P.ID\n" +
//            "WHERE PERSON_ID = ?" , nativeQuery = true)
//    List<Hardware> findHardwaresByPersonId (final Long hardwareList);

}