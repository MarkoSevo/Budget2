package com.demo.Budget2.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class HardwareTransactionDto {

    private LocalDateTime transactionDate;
    private Long hardwareId;
    private Long personId;
    private Long hardwareTransactionTypeId;

}
