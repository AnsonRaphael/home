package com.nanos.home.queryservice.service;

import com.nanos.home.queryservice.dto.HouseDto;

import java.util.List;

public interface HouseQueryService {
    List<HouseDto> getBudgetHome(Float minPrice, Float maxPrice);

    List<HouseDto> getSqFtHome(Float minSqFt);

    List<HouseDto> getAgeHome(Float year);
}
