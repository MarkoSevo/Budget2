package com.biss.demo.Budget2.service.impl;

import com.biss.demo.Budget2.dto.PositionDto;
import com.biss.demo.Budget2.model.Position;
import com.biss.demo.Budget2.repository.PositionJpaRepository;
import com.biss.demo.Budget2.service.PositionDtoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionDtoServiceImpl implements PositionDtoService {

    private final PositionJpaRepository positionJpaRepository;

    public PositionDtoServiceImpl(PositionJpaRepository positionJpaRepository) {
        this.positionJpaRepository = positionJpaRepository;
    }


    @Override
    public PositionDto findPositionByPosition(String positionName) {
        Position position = positionJpaRepository.findPositionByPosition(positionName);
        PositionDto dto = new PositionDto();
        dto.setId(position.getId());
        dto.setPosition(position.getPosition());
        return dto;
    }

    @Override
    public PositionDto findPositionById(Long id) {
        Position position = positionJpaRepository.getOne(id);
        PositionDto dto = new PositionDto();
        dto.setPosition(position.getPosition());
        return dto;
    }

    @Override
    public List<Position> findAll(Long position) {
        return positionJpaRepository.findAll();
    }

    @Override
    public Position save(Position newPosition) {
        return positionJpaRepository.save(newPosition);
    }


}
