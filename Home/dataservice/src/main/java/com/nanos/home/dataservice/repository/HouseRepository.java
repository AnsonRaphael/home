package com.nanos.home.dataservice.repository;

import com.nanos.home.dataservice.model.House;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HouseRepository extends JpaRepository<House,Long> {
    List<House> findAllByPriceBetween(Float minPrice,Float maxPrice);
    List<House> findAllBySqFtLivingGreaterThan(Float minSqFt);
    List<House> findAllByYrBuiltGreaterThanOrYrRenovatedGreaterThan (Float yearBlt,Float yearRnw);
}
