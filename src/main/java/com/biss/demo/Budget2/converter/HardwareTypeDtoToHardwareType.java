package com.biss.demo.Budget2.converter;

import com.biss.demo.Budget2.dto.HardwareTypeDto;
import com.biss.demo.Budget2.model.HardwareType;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class HardwareTypeDtoToHardwareType implements Converter<HardwareTypeDto, HardwareType> {
    @Override
    public HardwareType convert(HardwareTypeDto source) {
        return new HardwareType(source.getIdDto(),null,source.getType(),null);
    }
}
