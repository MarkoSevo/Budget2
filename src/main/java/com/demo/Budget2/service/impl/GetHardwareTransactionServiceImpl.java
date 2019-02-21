package com.demo.Budget2.service.impl;

import com.demo.Budget2.dto.GetHardwareTransaction;
import com.demo.Budget2.model.HardwareTransaction;
import com.demo.Budget2.repository.HardwareTransactionJpaRepository;
import com.demo.Budget2.service.GetHardwareTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GetHardwareTransactionServiceImpl implements GetHardwareTransactionService {

    private final ConversionService conversionService;
    private final HardwareTransactionJpaRepository hardwareTransactionJpaRepository;

    @Autowired
    public GetHardwareTransactionServiceImpl(ConversionService conversionService, HardwareTransactionJpaRepository hardwareTransactionJpaRepository) {
        this.conversionService = conversionService;
        this.hardwareTransactionJpaRepository = hardwareTransactionJpaRepository;
    }

    @Override
    public List<GetHardwareTransaction> findAllByPerson(Long id) {
        return (List<GetHardwareTransaction>) conversionService.convert(hardwareTransactionJpaRepository.findHardwareTransactionsByPersonId(id), TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(HardwareTransaction.class)),
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(GetHardwareTransaction.class)));
    }

    @Override
    public List<GetHardwareTransaction> findAllByHardware(Long id) {
        return (List<GetHardwareTransaction>) conversionService.convert(hardwareTransactionJpaRepository.findAllByHardware_Id(id), TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(HardwareTransaction.class)),
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(GetHardwareTransaction.class)));
    }

    @Override
    public List<GetHardwareTransaction> findAll() {
        return (List<GetHardwareTransaction>) conversionService.convert(hardwareTransactionJpaRepository.findAll(), TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(HardwareTransaction.class)),
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(GetHardwareTransaction.class)));
    }
}
