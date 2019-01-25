package com.biss.demo.Budget2.converter;

import com.biss.demo.Budget2.dto.BudgetDto;
import com.biss.demo.Budget2.model.Budget;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class BudgetToBudgetDtoConverter implements Converter<Budget, BudgetDto> {

    @Override
    public BudgetDto convert(Budget source) {
        return new BudgetDto(source.getId(), source.getVersion(), source.getAmount(),null);
    }
}
