package com.nanos.home.dataservice.service;

import com.nanos.home.dataservice.model.House;

import java.util.List;

public interface HouseService {
    List<House> getBudgetHome(Float minPrice, Float maxPrice);

    List<House> getSqFtHome(Float minSqFt);

    List<House> getAgeHome(Float year);
}
