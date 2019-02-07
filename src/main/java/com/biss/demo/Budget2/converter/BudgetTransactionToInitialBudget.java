package com.biss.demo.Budget2.converter;

import com.biss.demo.Budget2.dto.InitialBudgetDto;
import com.biss.demo.Budget2.model.BudgetTransaction;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class BudgetTransactionToInitialBudget  implements Converter<BudgetTransaction, InitialBudgetDto> {
    @Override
    public InitialBudgetDto convert(BudgetTransaction source) {
        return new InitialBudgetDto(null, source.getInputAmount(),source.getTransactionDate());
    }
}
