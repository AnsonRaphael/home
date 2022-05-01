package com.nanos.home.dataservice.service;

import com.nanos.home.dataservice.model.House;
import com.nanos.home.dataservice.repository.HouseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class HouseServiceImpl implements HouseService {

    private HouseRepository houseRepository;
    @Override
    public List<House> getBudgetHome(Float minPrice, Float maxPrice) {
        List<House> houses= houseRepository.findAllByPriceBetween(minPrice,maxPrice);
        return houses;
    }

    @Override
    public List<House> getSqFtHome(Float minSqFt) {
        List<House> houses= houseRepository.findAllBySqFtLivingGreaterThan(minSqFt);
        return houses;
    }

    @Override
    public List<House> getAgeHome(Float year) {
        List<House> houses= houseRepository.findAllByYrBuiltGreaterThanOrYrRenovatedGreaterThan(year,year);
        return houses;
    }
}
