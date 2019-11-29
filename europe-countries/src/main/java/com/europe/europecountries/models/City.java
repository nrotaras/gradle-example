package com.europe.europecountries.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "cities")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class City {

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    private Long id;

    @Column(name = "city_name", nullable = false, length = 150)
    private String name;

    @Column(name = "district_name", nullable = false, length = 150)
    private String district;

    private int population;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Country idCountry;


}
