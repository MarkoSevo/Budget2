package com.biss.demo.Budget2.converter;

import com.biss.demo.Budget2.dto.HardwareTypeDto;
import com.biss.demo.Budget2.model.HardwareType;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class HardwareTypeToHardwareTypeDto implements Converter<HardwareType, HardwareTypeDto> {
    @Override
    public HardwareTypeDto convert(HardwareType source) {
        return new HardwareTypeDto(source.getId(),source.getType());
    }
}