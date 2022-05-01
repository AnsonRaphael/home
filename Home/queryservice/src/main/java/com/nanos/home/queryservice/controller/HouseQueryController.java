package com.nanos.home.queryservice.controller;

import com.nanos.home.queryservice.dto.HouseDto;
import com.nanos.home.queryservice.service.HouseQueryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/house/data/")
@AllArgsConstructor
public class HouseQueryController {

    private HouseQueryService houseService;
    @GetMapping("getBudgetHome")
    public List<HouseDto> getBudgetHome(@RequestParam("minPrice") Float minPrice, @RequestParam("maxPrice") Float maxPrice){
        List<HouseDto> houses= houseService.getBudgetHome(minPrice,maxPrice);
        return houses;
    }

    @GetMapping("getSqFtHome")
    public List<HouseDto> getSqFtHome(@RequestParam("minSqFt") Float minSqFt){
        List<HouseDto> houses= houseService.getSqFtHome(minSqFt);
        return houses;
    }

    @GetMapping("getAgeHome")
    public List<HouseDto> getAgeHome(@RequestParam("year") Float year){
        List<HouseDto> houses= houseService.getAgeHome(year);
        return houses;
    }
}
