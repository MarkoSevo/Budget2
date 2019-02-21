package com.demo.Budget2.converter;

import com.demo.Budget2.dto.BudgetInputTransactionDto;
import com.demo.Budget2.dto.BudgetOutputTransactionDto;
import com.demo.Budget2.dto.BudgetTransactionPersonDto;
import com.demo.Budget2.dto.InitialBudgetDto;
import com.demo.Budget2.model.BudgetTransaction;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

public class BudgetTransactionConverter {

    @Component
    public static class BudgetInputTransactionDtoToBudgetInputTransaction implements Converter<BudgetInputTransactionDto, BudgetTransaction> {
        @Override
        public BudgetTransaction convert(BudgetInputTransactionDto source) {
            return new BudgetTransaction(null,null,source.getAmount(),null,source.getTransactionDate(),null,null);
        }
    }

    @Component
    public static class BudgetOutputTransactionDtoToBudgetTransaction implements Converter<BudgetOutputTransactionDto, BudgetTransaction> {
        @Override
        public BudgetTransaction convert(BudgetOutputTransactionDto source) {
            return new BudgetTransaction(null,null,null,source.getAmount(),source.getTransactionDate(),null,null);
        }
    }

    @Component
    public static class BudgetInputTransactionToBudgetInputTransactionDto implements Converter<BudgetTransaction, BudgetInputTransactionDto> {
        @Override
        public BudgetInputTransactionDto convert(BudgetTransaction source) {
            return new BudgetInputTransactionDto(source.getInputAmount(),source.getTransactionDate(),source.getPerson().getId());
        }
    }

    @Component
    public static class BudgetTransactionBudgetTransactionPersonDto implements Converter<BudgetTransaction, BudgetTransactionPersonDto> {
        @Override
        public BudgetTransactionPersonDto convert(BudgetTransaction source) {
            return new BudgetTransactionPersonDto(source.getPerson().getId(),source.getInputAmount(),source.getOutputAmount(),source.getTransactionDate());
        }
    }

    @Component
    public static class BudgetTransactionPersonDtoBudgetTransaction implements Converter<BudgetTransactionPersonDto, BudgetTransaction> {
        @Override
        public BudgetTransaction convert(BudgetTransactionPersonDto source) {
            return new BudgetTransaction(null,null,source.getInputAmount(),source.getOutputAmount(),source.getTransactionDate(),null,null);
        }
    }

    @Component
    public static class BudgetTransactionToBudgetOutputTransactionDto implements Converter<BudgetTransaction, BudgetOutputTransactionDto> {
        @Override
        public BudgetOutputTransactionDto convert(BudgetTransaction source) {
            return new BudgetOutputTransactionDto(source.getOutputAmount(),source.getTransactionDate(),source.getPerson().getId());
        }
    }

    @Component
    public static class BudgetTransactionToInitialBudget  implements Converter<BudgetTransaction, InitialBudgetDto> {
        @Override
        public InitialBudgetDto convert(BudgetTransaction source) {
            return new InitialBudgetDto(null, source.getInputAmount());
        }
    }
}
