package com.biss.demo.Budget2.converter;

import com.biss.demo.Budget2.dto.PersonBudgetDto;
import com.biss.demo.Budget2.model.Budget;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class BudgetToPersonDetailsDto implements Converter<Budget, PersonBudgetDto> {
    @Override
    public PersonBudgetDto convert(Budget source) {
        return new PersonBudgetDto(source.getId(),source.getVersion(),source.getAmount());
    }
}
