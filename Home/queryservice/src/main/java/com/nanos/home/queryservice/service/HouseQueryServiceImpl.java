package com.nanos.home.queryservice.service;

import com.nanos.home.queryservice.dto.AddressDto;
import com.nanos.home.queryservice.dto.HouseDto;

import lombok.RequiredArgsConstructor;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HouseQueryServiceImpl implements HouseQueryService {

    @Autowired
    RestTemplate restTemplate;
    String DATA_SERVICE_HOST_URL="http://localhost:8081/api/v1/house/data/";
    @Override
    public List<HouseDto> getBudgetHome(Float minPrice, Float maxPrice) {
        String url =DATA_SERVICE_HOST_URL+"/getBudgetHome?minPrice="+minPrice+"&maxPrice="+maxPrice;
        String response =  restTemplate.getForObject(url, String.class );
        JSONArray jsonArray = new JSONArray(response);
        List<HouseDto> houses = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject houseObj = jsonArray.getJSONObject(i);
            JSONObject addObj = houseObj.getJSONObject("address");

            AddressDto addressDto = AddressDto.builder()
                    .addressId(addObj.getLong("addressId"))
                    .street(addObj.getString("street"))
                    .city(addObj.getString("city"))
                    .stateZip(addObj.getString("stateZip"))
                    .country(addObj.getString("country"))
                    .build();
            HouseDto house = HouseDto.builder()
                    .houseId(houseObj.getLong("houseId"))
                    .addressDto(addressDto)
                    .date(houseObj.getString("date"))
                    .price(houseObj.getFloat("price"))
                    .bedrooms(houseObj.getFloat("bedrooms"))
                    .bathrooms(houseObj.getFloat("bathrooms"))
                    .sqFtLiving(houseObj.getFloat("sqFtLiving"))
                    .sqFtLot(houseObj.getFloat("sqFtLot"))
                    .floors(houseObj.getFloat("floors"))
                    .waterfront(houseObj.getFloat("waterfront"))
                    .view(houseObj.getFloat("view"))
                    .condition(houseObj.getFloat("condition"))
                    .sqFtAbove(houseObj.getFloat("sqFtAbove"))
                    .sqFtBasement(houseObj.getFloat("sqFtBasement"))
                    .yrBuilt(houseObj.getFloat("yrBuilt"))
                    .yrRenovated(houseObj.getFloat("yrRenovated"))
                    .build();
            houses.add(house);

        }
        return houses;
    }

    @Override
    public List<HouseDto> getSqFtHome(Float minSqFt) {
        String url =DATA_SERVICE_HOST_URL+"/getSqFtHome?minSqFt="+minSqFt;
        String response =  restTemplate.getForObject(url, String.class );
        JSONArray jsonArray = new JSONArray(response);
        List<HouseDto> houses = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject houseObj = jsonArray.getJSONObject(i);
            JSONObject addObj = houseObj.getJSONObject("address");

            AddressDto addressDto = AddressDto.builder()
                    .addressId(addObj.getLong("addressId"))
                    .street(addObj.getString("street"))
                    .city(addObj.getString("city"))
                    .stateZip(addObj.getString("stateZip"))
                    .country(addObj.getString("country"))
                    .build();
            HouseDto house = HouseDto.builder()
                    .houseId(houseObj.getLong("houseId"))
                    .addressDto(addressDto)
                    .date(houseObj.getString("date"))
                    .price(houseObj.getFloat("price"))
                    .bedrooms(houseObj.getFloat("bedrooms"))
                    .bathrooms(houseObj.getFloat("bathrooms"))
                    .sqFtLiving(houseObj.getFloat("sqFtLiving"))
                    .sqFtLot(houseObj.getFloat("sqFtLot"))
                    .floors(houseObj.getFloat("floors"))
                    .waterfront(houseObj.getFloat("waterfront"))
                    .view(houseObj.getFloat("view"))
                    .condition(houseObj.getFloat("condition"))
                    .sqFtAbove(houseObj.getFloat("sqFtAbove"))
                    .sqFtBasement(houseObj.getFloat("sqFtBasement"))
                    .yrBuilt(houseObj.getFloat("yrBuilt"))
                    .yrRenovated(houseObj.getFloat("yrRenovated"))
                    .build();
            houses.add(house);

        }
        return houses;
    }

    @Override
    public List<HouseDto> getAgeHome(Float year) {
        String url =DATA_SERVICE_HOST_URL+"/getAgeHome?year="+year;
        String response =  restTemplate.getForObject(url, String.class );
        JSONArray jsonArray = new JSONArray(response);
        List<HouseDto> houses = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject houseObj = jsonArray.getJSONObject(i);
            JSONObject addObj = houseObj.getJSONObject("address");

            AddressDto addressDto = AddressDto.builder()
                    .addressId(addObj.getLong("addressId"))
                    .street(addObj.getString("street"))
                    .city(addObj.getString("city"))
                    .stateZip(addObj.getString("stateZip"))
                    .country(addObj.getString("country"))
                    .build();
            HouseDto house = HouseDto.builder()
                    .houseId(houseObj.getLong("houseId"))
                    .addressDto(addressDto)
                    .date(houseObj.getString("date"))
                    .price(houseObj.getFloat("price"))
                    .bedrooms(houseObj.getFloat("bedrooms"))
                    .bathrooms(houseObj.getFloat("bathrooms"))
                    .sqFtLiving(houseObj.getFloat("sqFtLiving"))
                    .sqFtLot(houseObj.getFloat("sqFtLot"))
                    .floors(houseObj.getFloat("floors"))
                    .waterfront(houseObj.getFloat("waterfront"))
                    .view(houseObj.getFloat("view"))
                    .condition(houseObj.getFloat("condition"))
                    .sqFtAbove(houseObj.getFloat("sqFtAbove"))
                    .sqFtBasement(houseObj.getFloat("sqFtBasement"))
                    .yrBuilt(houseObj.getFloat("yrBuilt"))
                    .yrRenovated(houseObj.getFloat("yrRenovated"))
                    .build();
            houses.add(house);

        }
        return houses;
    }
}
