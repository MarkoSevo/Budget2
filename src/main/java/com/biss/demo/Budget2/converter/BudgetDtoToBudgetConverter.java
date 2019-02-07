package com.biss.demo.Budget2.converter;

import com.biss.demo.Budget2.dto.BudgetDto;
import com.biss.demo.Budget2.model.Budget;
import com.biss.demo.Budget2.model.Position;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class BudgetDtoToBudgetConverter implements Converter<BudgetDto, Budget> {

    @Override
    public Budget convert(BudgetDto source) {
        return new Budget(null,null, source.getAmount(),null);
    }
}