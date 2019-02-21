package com.demo.Budget2.converter;

import com.demo.Budget2.dto.HardwareTypeDto;
import com.demo.Budget2.model.HardwareType;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

public class HardwareTypeConverter {

    @Component
    public static class HardwareTypeDtoToHardwareType implements Converter<HardwareTypeDto, HardwareType> {
        @Override
        public HardwareType convert(HardwareTypeDto source) {
            return new HardwareType(source.getId(),null,source.getType(),null);
        }
    }

    @Component
    public static class HardwareTypeToHardwareTypeDto implements Converter<HardwareType, HardwareTypeDto> {
        @Override
        public HardwareTypeDto convert(HardwareType source) {
            return new HardwareTypeDto(source.getId(),source.getType());
        }
    }
}
