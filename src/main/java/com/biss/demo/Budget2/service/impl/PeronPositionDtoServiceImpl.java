package com.biss.demo.Budget2.service.impl;

import com.biss.demo.Budget2.dto.PersonPositionDto;
import com.biss.demo.Budget2.model.PersonPosition;
import com.biss.demo.Budget2.repository.PersonPositionJpaRepository;
import com.biss.demo.Budget2.service.PeronPositionDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

@Service
public class PeronPositionDtoServiceImpl implements PeronPositionDtoService {

    private final ConversionService conversionService;
    private final PersonPositionJpaRepository personPositionJpaRepository;

    @Autowired
    public PeronPositionDtoServiceImpl(ConversionService conversionService, PersonPositionJpaRepository personPositionJpaRepository) {
        this.conversionService = conversionService;
        this.personPositionJpaRepository = personPositionJpaRepository;
    }

    @Override
    public PersonPositionDto save(PersonPositionDto personPositionDto) {
        PersonPosition personPosition = new PersonPosition();
        conversionService.convert(personPositionDto, PersonPosition.class);
        personPositionJpaRepository.save(personPosition);
        return personPositionDto;

    }
}
