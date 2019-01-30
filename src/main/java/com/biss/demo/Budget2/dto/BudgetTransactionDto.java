package com.biss.demo.Budget2.dto;

import com.biss.demo.Budget2.model.Person;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class BudgetTransactionDto {

    private BigDecimal inputAmount;
    private BigDecimal outputAmount;
    private Date transactionDate;
    private PersonDetailsDto personDto;
}
