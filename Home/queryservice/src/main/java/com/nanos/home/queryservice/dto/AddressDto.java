package com.nanos.home.queryservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {

    private Long addressId;

    private String street;
    private String city;
    private String stateZip;
    private String country;
}
