package com.nanos.home.dataservice.controller;

import com.nanos.home.dataservice.model.House;
import com.nanos.home.dataservice.service.HouseService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/house/data/")
@CrossOrigin(value = "http://localhost:8080/")
@AllArgsConstructor
public class HouseController {
    private HouseService houseService;
    @GetMapping("getBudgetHome")
    public List<House> getBudgetHome(@RequestParam("minPrice") Float minPrice,@RequestParam("maxPrice") Float maxPrice){
        List<House> houses= houseService.getBudgetHome(minPrice,maxPrice);
        return houses;
    }

    @GetMapping("getSqFtHome")
    public List<House> getSqFtHome(@RequestParam("minSqFt") Float minSqFt){
        List<House> houses= houseService.getSqFtHome(minSqFt);
        return houses;
    }

    @GetMapping("getAgeHome")
    public List<House> getAgeHome(@RequestParam("year") Float year){
        List<House> houses= houseService.getAgeHome(year);
        return houses;
    }
}
