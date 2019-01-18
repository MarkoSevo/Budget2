package com.biss.demo.Budget2.repository;

import com.biss.demo.Budget2.model.Hardware;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Date;
import java.util.List;

@Repository
public interface HardwareJpaRepository extends JpaRepository<Hardware, Long> {
    Hardware findHardwareById(final Long id);
    Hardware findHardwareBySerialNumber (final Long serial);
    List<Hardware> findHardwareByPurchaseDate (final Date purchaseDate);
    List<Hardware> findAllByHardwareType (final Long hardwareType);
}