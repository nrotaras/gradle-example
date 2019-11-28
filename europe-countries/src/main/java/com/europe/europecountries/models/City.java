package com.europe.europecountries.models;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "cities")
@Data
public class City {

    @GeneratedValue
    @Id
    private Long id;

    @Column(name = "city_name", nullable = false, length = 150)
    private String name;

    @Column(name = "district_name", nullable = false, length = 150)
    private String district;

    private int population;


}
