package com.demo.Budget2.converter;

import com.demo.Budget2.dto.GetHardwareTransaction;
import com.demo.Budget2.dto.HardwareTransactionDto;
import com.demo.Budget2.model.HardwareTransaction;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

public class HardwareTransactionConverter {

    @Component
    public static class HardwareTransactionDtoToHardwareTransaction implements Converter<HardwareTransactionDto, HardwareTransaction> {

        @Override
        public HardwareTransaction convert(HardwareTransactionDto source) {
            return new HardwareTransaction(null,null,source.getTransactionDate(), null,null,null);
        }
    }

    @Component
    public static class HardwareTransactionGetHardwareTransaction implements Converter<HardwareTransaction, GetHardwareTransaction> {
        @Override
        public GetHardwareTransaction convert(HardwareTransaction source) {
            return new GetHardwareTransaction(source.getPerson().getId(), source.getTransactionDate(),source.getHardware().getId(),source.getHardwareTransactionType().getType(),source.getHardware().getPrice());
        }
    }

    @Component
    public static class HardwareTransactionToHardwareTransactionDto implements Converter<HardwareTransaction, HardwareTransactionDto> {

        @Override
        public HardwareTransactionDto convert(HardwareTransaction source) {
                return new HardwareTransactionDto(source.getTransactionDate(), source.getHardware().getId(),null,null);
        }
    }

    @Component
    public static class GetHardwareTransactionHardwareTransaction implements Converter<GetHardwareTransaction, HardwareTransaction> {
        @Override
        public HardwareTransaction convert(GetHardwareTransaction source) {
            return new HardwareTransaction(null,null,source.getTransactionDate(),null, null,null);
        }
    }
}
