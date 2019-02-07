package com.biss.demo.Budget2.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InitialBudgetTransactionDto {

    private Long personId;
    private BigDecimal amount;
}
