package com.biss.demo.Budget2.service.impl;

import com.biss.demo.Budget2.dto.PersonPositionDto;
import com.biss.demo.Budget2.model.PersonPosition;
import com.biss.demo.Budget2.repository.PersonPositionJpaRepository;
import com.biss.demo.Budget2.service.PeronPositionDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

@Service
public class PersonPositionDtoServiceImpl implements PeronPositionDtoService {

    private final ConversionService conversionService;
    private final PersonPositionJpaRepository personPositionJpaRepository;

    @Autowired
    public PersonPositionDtoServiceImpl(ConversionService conversionService, PersonPositionJpaRepository personPositionJpaRepository) {
        this.conversionService = conversionService;
        this.personPositionJpaRepository = personPositionJpaRepository;
    }

    @Override
    public Long findByPersonId(Long id) {
        PersonPosition personPosition = new PersonPosition();
        PersonPositionDto dto = new PersonPositionDto();
        dto.setPositionId(personPositionJpaRepository.findByPerson_Id(id));
        conversionService.convert(personPosition,PersonPosition.class);
        return null;
    }
}
