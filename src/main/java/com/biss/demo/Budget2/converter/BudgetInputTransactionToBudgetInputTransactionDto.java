package com.biss.demo.Budget2.converter;

import com.biss.demo.Budget2.dto.BudgetInputTransactionDto;
import com.biss.demo.Budget2.model.BudgetTransaction;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class BudgetInputTransactionToBudgetInputTransactionDto implements Converter<BudgetTransaction, BudgetInputTransactionDto> {
    @Override
    public BudgetInputTransactionDto convert(BudgetTransaction source) {
        return new BudgetInputTransactionDto(source.getInputAmount(),source.getTransactionDate(),null);
    }
}
