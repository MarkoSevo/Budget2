package com.biss.demo.Budget2.controller;

import com.biss.demo.Budget2.dto.BudgetDto;
import com.biss.demo.Budget2.model.Budget;
import com.biss.demo.Budget2.repository.BudgetJpaRepository;
import com.biss.demo.Budget2.service.impl.BudgetDtoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;


@RestController
@RequestMapping("/budgets")
public class BudgetController {

    private final BudgetJpaRepository jpaRepository;
    private final ConversionService conversionService;
    private final BudgetDtoServiceImpl budgetDtoServiceImpl;


    @Autowired
    public BudgetController(final BudgetJpaRepository jpaRepository, ConversionService conversionService, BudgetDtoServiceImpl budgetDtoService) {
        this.jpaRepository = jpaRepository;
        this.conversionService = conversionService;
        this.budgetDtoServiceImpl = budgetDtoService;
    }

    @PostMapping (value = "/post")
    public Budget save(@RequestBody BudgetDto amount){
        return jpaRepository.save(conversionService.convert(amount, Budget.class));
    }

    @GetMapping (value = "/id/{id}")
    public BudgetDto getBudgetDto(final @PathVariable("id") Long id){
        return conversionService.convert(jpaRepository.findBudgetById(id), BudgetDto.class);
    }

    @GetMapping (value = "/amount/{amount}")
    public BudgetDto findBudgetByAmount (final @PathVariable ("amount")BigDecimal amount){
        return conversionService.convert(jpaRepository.findBudgetByAmount(amount), BudgetDto.class);
    }

    @GetMapping(value = "/positionId/{id}")
    public BigDecimal findBudgetByPosition(final @PathVariable Long id){
        return budgetDtoServiceImpl.findBudgetByPosition(id);
    }

//    @GetMapping (value = "/all")
//    public List<BudgetDto> findALL() {
//        return (List<BudgetDto>) conversionService.convert(jpaRepository.findAll(), TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(Budget.class)),
//                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(BudgetDto.class)));
//    }

}
