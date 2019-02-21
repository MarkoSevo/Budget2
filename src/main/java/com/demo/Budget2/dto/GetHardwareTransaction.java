package com.demo.Budget2.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.PrePersist;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class GetHardwareTransaction {

    private Long personId;
    private LocalDateTime transactionDate;
    private Long hardwareId;
    private String hardwareTransactionType;
    private BigDecimal hardwarePrice;

}
