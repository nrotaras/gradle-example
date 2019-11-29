package com.europe.europecountries.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "countries")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Country {

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "code", nullable = false, unique = true, length = 4)
    private String code;

    @Column(name = "country_name", nullable = false, length = 150)
    private String name;

    @Column(name = "country_region", nullable = false)
    private String region;

    @Column(name = "surface_area")
    private long surfaceArea;

    private int population;

    //mapping with "country_lang" entity
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "country")
    private List<CountryLanguage> languages;

    //mapping with "cities" entity
    @OneToMany(cascade = CascadeType.ALL)
    private List<City> cities;


}
