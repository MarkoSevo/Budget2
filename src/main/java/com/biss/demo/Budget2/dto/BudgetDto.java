package com.biss.demo.Budget2.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BudgetDto {

    @JsonIgnore
    private Long version;
    private Long positionId;
    private BigDecimal amount;

}
