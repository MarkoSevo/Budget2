package com.biss.demo.Budget2.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class GetHardwareTransaction {

    private Long personId;
    private Date transactionDate;
    private Long hardwareId;
    private String hardwareTransactionType;
    private BigDecimal hardwarePrice;

}
