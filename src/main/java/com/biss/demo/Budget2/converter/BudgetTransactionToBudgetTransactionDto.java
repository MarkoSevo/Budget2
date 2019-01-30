package com.biss.demo.Budget2.converter;

import com.biss.demo.Budget2.dto.BudgetDto;
import com.biss.demo.Budget2.dto.BudgetTransactionDto;
import com.biss.demo.Budget2.model.Budget;
import com.biss.demo.Budget2.model.BudgetTransaction;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class BudgetTransactionToBudgetTransactionDto implements Converter<BudgetTransaction, BudgetTransactionDto> {
    @Override
    public BudgetTransactionDto convert(BudgetTransaction source) {
        return new BudgetTransactionDto(source.getInputAmount(),source.getOutputAmount(),source.getTransactionDate(),null);
    }
}
