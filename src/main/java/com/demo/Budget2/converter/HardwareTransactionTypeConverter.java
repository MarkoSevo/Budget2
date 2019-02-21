package com.demo.Budget2.converter;

import com.demo.Budget2.dto.HardwareTransactionTypeDto;
import com.demo.Budget2.model.HardwareTransactionType;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

public class HardwareTransactionTypeConverter {

    @Component
    public static class HardwareTransactionTypeToHardwareTransactionTypeDto implements Converter<HardwareTransactionType, HardwareTransactionTypeDto> {
        @Override
        public HardwareTransactionTypeDto convert(HardwareTransactionType source) {
            return new HardwareTransactionTypeDto(source.getId(),source.getType());
        }
    }

    @Component
    public static class HardwareTransactionTypeDtoToHardwareTransactionType implements Converter <HardwareTransactionTypeDto, HardwareTransactionType> {
        @Override
        public HardwareTransactionType convert(HardwareTransactionTypeDto source) {
            return new HardwareTransactionType(source.getId(),null,source.getType(),null);
        }
    }
}
