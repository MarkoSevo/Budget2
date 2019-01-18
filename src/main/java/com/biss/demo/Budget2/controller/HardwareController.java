package com.biss.demo.Budget2.controller;

import com.biss.demo.Budget2.dto.HardwareDto;
import com.biss.demo.Budget2.model.Hardware;
import com.biss.demo.Budget2.repository.HardwareJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/hardwares")
public class HardwareController {

    private final HardwareJpaRepository jpaRepository;
    private final ConversionService conversionService;

    @Autowired
    public HardwareController(HardwareJpaRepository jpaRepository, ConversionService conversionService) {
        this.jpaRepository = jpaRepository;
        this.conversionService = conversionService;
    }

    @PostMapping (value = "/post/")
    public Hardware save(@RequestBody HardwareDto newHardware){
        return jpaRepository.save(conversionService.convert(newHardware, Hardware.class));
    }

    @GetMapping (value = "/id/{id}")
    public HardwareDto getHardwareDto(final @PathVariable("id") Long id){
        return conversionService.convert(jpaRepository.findHardwareById(id), HardwareDto.class);
    }

    @GetMapping (value = "/type/{type}")
    public HardwareDto findHardwareByType (final @PathVariable ("type") Long hardwareType){
        return conversionService.convert(jpaRepository.findAllByHardwareType(hardwareType), HardwareDto.class);
    }
    @DeleteMapping(value = "/id/{id}")
    public void delete(@PathVariable("id") Long id) {
        jpaRepository.deleteById(id);
    }
}


//    @GetMapping(value = "/all")
//    public List<Hardware> allHardwares() {
//        return jpaRepository.findAll();
//    }
//
//    @GetMapping(value = "/id/{id}")
//    public Hardware findHardwareById(final @PathVariable("id") Long id) {
//        return jpaRepository.findHardwareById(id);
//    }
//
//    @GetMapping (value = "/purchaseDate/{purchaseDate}")
//    public List<Hardware> findHardwareByPurchaseDate(final @PathVariable("purchaseDate")
//                                                         @DateTimeFormat(pattern="MMddyyyy")Date purchase_date)
//    {return jpaRepository.findHardwareByPurchaseDate(purchase_date);}
//
//    @GetMapping(value = "/serial/{serial}")
//    public Hardware findHardwareBySerialNumber(final @PathVariable("serial") Long serial){
//        return jpaRepository.findHardwareBySerialNumber(serial);
//    }



