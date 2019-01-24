package com.biss.demo.Budget2.controller;

import com.biss.demo.Budget2.dto.BudgetDto;
import com.biss.demo.Budget2.dto.PositionDto;
import com.biss.demo.Budget2.model.Budget;
import com.biss.demo.Budget2.model.Position;
import com.biss.demo.Budget2.repository.BudgetJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.util.List;


@RestController
@RequestMapping("/budgets")
public class BudgetController {

    private final BudgetJpaRepository jpaRepository;
    private final ConversionService conversionService;

    @Autowired
    public BudgetController(final BudgetJpaRepository jpaRepository, ConversionService conversionService) {
        this.jpaRepository = jpaRepository;
        this.conversionService = conversionService;
    }

    @PostMapping (value = "/newbudget/post/")
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

    @GetMapping (value = "/all")
    public List<BudgetDto> findALL() {
        return (List<BudgetDto>) conversionService.convert(jpaRepository.findAll(), TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(Budget.class)),
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(BudgetDto.class)));
    }

}
