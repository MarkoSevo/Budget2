package com.biss.demo.Budget2.converter;

import com.biss.demo.Budget2.dto.HardwareDetailsDto;
import com.biss.demo.Budget2.model.Hardware;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class HardwareDetailsDtoToHardwareConverter implements Converter<HardwareDetailsDto, Hardware> {
    @Override
    public Hardware convert(HardwareDetailsDto source) {
        return new Hardware(source.getId(),null,source.getSerialNumber(),source.getPrice(),null,source.getHardwareType(),null);
    }
}
