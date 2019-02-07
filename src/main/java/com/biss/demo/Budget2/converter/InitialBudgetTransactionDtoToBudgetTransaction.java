package com.biss.demo.Budget2.converter;

import com.biss.demo.Budget2.model.BudgetTransaction;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class InitialBudgetTransactionDtoToBudgetTransaction implements Converter<InitialBudgetToBudgetTransaction, BudgetTransaction> {
    @Override
    public BudgetTransaction convert(InitialBudgetToBudgetTransaction source) {
        return new BudgetTransaction();
    }
}
