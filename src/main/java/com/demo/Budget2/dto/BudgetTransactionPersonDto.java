package com.demo.Budget2.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BudgetTransactionPersonDto {

    private Long personId;
    private BigDecimal inputAmount;
    private BigDecimal outputAmount;
    private LocalDateTime transactionDate;

}
