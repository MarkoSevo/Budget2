package com.biss.demo.Budget2.converter;

import com.biss.demo.Budget2.dto.BudgetDto;
import com.biss.demo.Budget2.model.Budget;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class BudgetDtoToBudgetConverter implements Converter<BudgetDto, Budget> {

    @Override
    public Budget convert(BudgetDto source) {
        return new Budget(source.getId(),source.getVersion(),source.getAmount());
    }
}