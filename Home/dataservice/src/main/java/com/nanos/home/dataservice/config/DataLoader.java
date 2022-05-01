package com.nanos.home.dataservice.config;

import com.nanos.home.dataservice.model.Address;
import com.nanos.home.dataservice.model.House;
import com.nanos.home.dataservice.repository.AddressRepository;
import com.nanos.home.dataservice.repository.HouseRepository;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    HouseRepository houseRepository ;
    @Autowired
    AddressRepository addressRepository;

    @Override
    public void run(String... args) throws Exception {
        File file = ResourceUtils.getFile("classpath:data.csv");
        InputStream in = new FileInputStream(file);
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

            List<House> houses = new ArrayList<>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for (CSVRecord csvRecord : csvRecords) {
                Address address = Address.builder()
                                .city(csvRecord.get("city"))
                                        .country(csvRecord.get("country"))
                                                .stateZip(csvRecord.get("statezip"))
                                                        .street(csvRecord.get("street"))
                                                                .build();
                address=addressRepository.saveAndFlush(address);
                House house = House.builder()
                                .address(address)
                                        .date(csvRecord.get("date"))
                                                .price(Float.valueOf(csvRecord.get("price")))
                                                        .bedrooms(Float.valueOf(csvRecord.get("bedrooms")))
                                                                .bathrooms(Float.valueOf(csvRecord.get("bathrooms")))
                                                                        .sqFtLiving(Float.valueOf(csvRecord.get("sqft_living")))
                                                                                .sqFtLot(Float.valueOf(csvRecord.get("sqft_lot")))
                                                                                        .floors(Float.valueOf(csvRecord.get("floors")))
                                                                                                .waterfront(Float.valueOf(csvRecord.get("waterfront")))
                                                                                                        .view(Float.valueOf(csvRecord.get("view")))
                                                                                                                .condition(Float.valueOf(csvRecord.get("condition")))
                                                                                                                        .sqFtAbove(Float.valueOf(csvRecord.get("sqft_above")))
                                                                                                                                .sqFtBasement(Float.valueOf(csvRecord.get("sqft_basement")))
                                                                                                                                        .yrBuilt(Float.valueOf(csvRecord.get("yr_built")))
                                                                                                                                                .yrRenovated(Float.valueOf(csvRecord.get("yr_renovated")))
                                                                                                                                                        .build();

                houses.add(house);
                houseRepository.saveAndFlush(house);
            }


        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }
}
