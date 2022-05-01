package com.nanos.home.queryservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HouseDto {
        private Long houseId;

        private Float price;
        private String date;
        private Float bedrooms;
        private Float bathrooms;
        private Float sqFtLiving;
        private Float sqFtLot;
        private Float floors;
        private Float waterfront;
        private Float view;
        private Float condition;
        private Float sqFtAbove;
        private Float sqFtBasement;
        private Float yrBuilt;
        private Float yrRenovated;
        private AddressDto addressDto;

}
