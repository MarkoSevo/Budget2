package com.biss.demo.Budget2.dto;

import lombok.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InitialBudgetDto {

    private Long positionId;
    private BigDecimal initialBudget;
    private Date transactionDate;
}
