package com.biss.demo.Budget2.service.impl;

import com.biss.demo.Budget2.dto.PositionDto;
import com.biss.demo.Budget2.model.Position;
import com.biss.demo.Budget2.repository.PositionJpaRepository;
import com.biss.demo.Budget2.service.PositionDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionDtoServiceImpl implements PositionDtoService {

    private final PositionJpaRepository positionJpaRepository;
    private final ConversionService conversionService;

    @Autowired
    public PositionDtoServiceImpl(PositionJpaRepository positionJpaRepository, ConversionService conversionService) {
        this.positionJpaRepository = positionJpaRepository;
        this.conversionService = conversionService;
    }


    @Override
    public PositionDto findPositionByPosition(String positionName) {
        Position position = positionJpaRepository.findPositionByPosition(positionName);
        PositionDto dto = new PositionDto();
        dto.setId(position.getId());
        dto.setPositionDto(position.getPosition());
        return dto;
    }

    @Override
    public PositionDto findPositionById(Long id) {
        Position position = positionJpaRepository.getOne(id);
        PositionDto dto = new PositionDto();
        dto.setPositionDto(position.getPosition());
        return dto;
    }

    @Override
    public List<PositionDto> findAll() {
        return (List<PositionDto>) conversionService.convert(positionJpaRepository.findAll(), TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(Position.class)),
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(PositionDto.class)));
    }

    @Override
    public Position save(Position newPosition) {
        return positionJpaRepository.save(newPosition);
    }
}
