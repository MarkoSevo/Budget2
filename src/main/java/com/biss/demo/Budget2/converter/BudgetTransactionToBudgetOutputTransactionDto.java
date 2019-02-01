package com.biss.demo.Budget2.converter;

import com.biss.demo.Budget2.dto.BudgetOutputTransactionDto;
import com.biss.demo.Budget2.model.BudgetTransaction;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class BudgetTransactionToBudgetOutputTransactionDto implements Converter<BudgetTransaction, BudgetOutputTransactionDto> {
    @Override
    public BudgetOutputTransactionDto convert(BudgetTransaction source) {
        return new BudgetOutputTransactionDto(source.getOutputAmount(),source.getTransactionDate(),null);
    }
}
