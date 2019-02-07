package com.biss.demo.Budget2.converter;

import com.biss.demo.Budget2.dto.InitialBudgetDto;
import com.biss.demo.Budget2.model.BudgetTransaction;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class InitialBudgetToBudgetTransaction implements Converter<InitialBudgetDto , BudgetTransaction> {
    @Override
    public BudgetTransaction convert(InitialBudgetDto source) {
        return new BudgetTransaction(null,null,source.getInitialBudget(),null,source.getTransactionDate(),null,null);
    }
}
