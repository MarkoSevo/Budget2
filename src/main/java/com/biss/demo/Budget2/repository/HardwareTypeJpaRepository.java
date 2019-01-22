package com.biss.demo.Budget2.repository;

import com.biss.demo.Budget2.model.Hardware;
import com.biss.demo.Budget2.model.HardwareType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HardwareTypeJpaRepository extends JpaRepository<HardwareType, Long> {

    Hardware findByType (String type);

//    @Query(value = "SELECT HARDWARE_TYPE.TYPE\n" +
//            "FROM HARDWARE_TYPE\n" +
//            "LEFT JOIN HARDWARE H on HARDWARE_TYPE.ID = H.HARDWARE_TYPE_ID\n" +
//            "WHERE HARDWARE_TYPE_ID =?"
//             ,nativeQuery = true)
//    String findHardwareTypeByHardwareId (String hardwareType);
}