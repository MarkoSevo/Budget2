package com.biss.demo.Budget2.converter;

import com.biss.demo.Budget2.dto.InitialBudgetTransactionDto;
import com.biss.demo.Budget2.model.BudgetTransaction;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class BudgetTransactionToInitialBudgetTransactionDto implements Converter<BudgetTransaction, InitialBudgetTransactionDto> {
    @Override
    public InitialBudgetTransactionDto convert(BudgetTransaction source) {
        return new InitialBudgetTransactionDto(source.getPerson().getId(),source.getInputAmount());
    }
}
