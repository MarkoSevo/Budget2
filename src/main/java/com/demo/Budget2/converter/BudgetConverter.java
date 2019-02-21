package com.demo.Budget2.converter;

import com.demo.Budget2.dto.*;
import com.demo.Budget2.model.Budget;
import com.demo.Budget2.dto.BudgetDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

public class BudgetConverter {

    @Component
    public static class BudgetDtoToBudget implements Converter<BudgetDto, Budget> {

        @Override
        public Budget convert(BudgetDto source) {
            return new Budget(null,null, source.getAmount(),null);
        }
    }

    @Component
    public static class BudgetToBudgetDto implements Converter<Budget, BudgetDto> {

        @Override
        public BudgetDto convert(Budget source) {
            return new BudgetDto(source.getId(), source.getAmount());
        }
    }



}
