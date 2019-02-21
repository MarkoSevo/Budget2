package com.demo.Budget2.dto;

import lombok.*;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InitialBudgetDto {

    private Long positionId;
    private BigDecimal initialBudget;

}
