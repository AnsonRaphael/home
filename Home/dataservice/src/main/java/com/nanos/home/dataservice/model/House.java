package com.nanos.home.dataservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.Date;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class House {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
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
    @OneToOne
    private Address address;

}
