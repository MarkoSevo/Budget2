package com.biss.demo.Budget2.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class GetHardwareTransaction implements Serializable {

    private Long personId;
    private Date transactionDate;
    private Long hardwareId;
    private String hardwareTransactionTypeId;
}
