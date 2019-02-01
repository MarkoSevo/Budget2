package com.biss.demo.Budget2.service.impl;

import com.biss.demo.Budget2.dto.HardwareDetailsDto;
import com.biss.demo.Budget2.dto.HardwareTransactionDto;
import com.biss.demo.Budget2.model.HardwareTransaction;
import com.biss.demo.Budget2.model.Person;
import com.biss.demo.Budget2.repository.HardwareJpaRepository;
import com.biss.demo.Budget2.repository.HardwareTransactionJpaRepository;
import com.biss.demo.Budget2.repository.HardwareTransactionTypeJpaRepository;
import com.biss.demo.Budget2.repository.PersonJpaRepository;
import com.biss.demo.Budget2.service.HardwareTransactionDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HardwareTransactionDtoServiceImpl implements HardwareTransactionDtoService {

    private final ConversionService conversionService;
    private final HardwareTransactionJpaRepository hardwareTransactionJpaRepository;
    private final HardwareJpaRepository hardwareJpaRepository;
    private final PersonJpaRepository personJpaRepository;
    private final HardwareTransactionTypeJpaRepository hardwareTransactionTypeJpaRepository;

    @Autowired
    public HardwareTransactionDtoServiceImpl(HardwareTransactionJpaRepository hardwareTransactionJpaRepository, ConversionService conversionService, HardwareJpaRepository hardwareJpaRepository, PersonJpaRepository personJpaRepository, HardwareTransactionTypeJpaRepository hardwareTransactionTypeJpaRepository) {
        this.conversionService = conversionService;
        this.hardwareTransactionJpaRepository = hardwareTransactionJpaRepository;
        this.hardwareJpaRepository = hardwareJpaRepository;
        this.personJpaRepository = personJpaRepository;
        this.hardwareTransactionTypeJpaRepository = hardwareTransactionTypeJpaRepository;
    }

    @Override
    public HardwareTransactionDto save(HardwareTransactionDto hardwareTransactionDto){
        HardwareTransaction hardwareTransaction = conversionService.convert(hardwareTransactionDto, HardwareTransaction.class);
        hardwareTransaction.setHardware(hardwareJpaRepository.getOne(hardwareTransactionDto.getHardwareId()));
        hardwareTransaction.setPerson(personJpaRepository.getOne(hardwareTransactionDto.getPersonId()));
        hardwareTransaction.setHardwareTransactionType(hardwareTransactionTypeJpaRepository.getOne(hardwareTransactionDto.getHardwareTransactionTypeId()));
        hardwareTransactionJpaRepository.save(hardwareTransaction);
        return hardwareTransactionDto;
    }

    @Override
    public HardwareTransactionDto getPersonHardware(Long id) {
        return null;
    }

    @Override
    public List<HardwareTransactionDto> getAllByPersonId() {
        Person person = new Person();
      return (List<HardwareTransactionDto>) conversionService.convert(hardwareTransactionJpaRepository.getAllByPersonId(person.getId()), TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(HardwareTransaction.class)),
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(HardwareTransactionDto.class)));

    }
}
