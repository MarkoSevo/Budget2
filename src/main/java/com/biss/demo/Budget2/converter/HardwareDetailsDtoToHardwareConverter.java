package com.biss.demo.Budget2.converter;

import com.biss.demo.Budget2.dto.HardwareDetailsDto;
import com.biss.demo.Budget2.model.Hardware;
import com.biss.demo.Budget2.service.impl.HardwareTypeDtoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class HardwareDetailsDtoToHardwareConverter implements Converter<HardwareDetailsDto, Hardware> {

    @Override
    public Hardware convert(HardwareDetailsDto source) {
        return new Hardware(source.getId(),null,source.getSerialNumber(),source.getPrice(),
                null,null,null,null);
    }
}