package com.biss.demo.Budget2.repository;

import com.biss.demo.Budget2.model.Hardware;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HardwareJpaRepository extends JpaRepository<Hardware, Long> {
    Hardware findHardwareById(final Long id);

    @Query(value = "SELECT TYPE, HARDWARE.ID\n" +
            "FROM HARDWARE\n" +
            "JOIN HARDWARE_TYPE\n" +
            "ON HARDWARE.HARDWARE_TYPE_ID = HARDWARE_TYPE.ID\n" +
            "WHERE TYPE = ? ", nativeQuery = true)
    String findByHardwareTypes (final String hardwareType);

    Hardware findHardwareByHardwareType (final String type);
}