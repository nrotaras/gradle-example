package com.europe.europecountries.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "countries")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Country {

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    private Long id;

    @Column(name = "code", nullable = false, length = 4)
    private String code;

    @Column(name = "country_name", nullable = false, length = 150)
    private String name;

    @Column(name = "country_region", nullable = false)
    private String region;

    private long surfaceArea;

    private int population;

    @CreationTimestamp
    @Column(name = "insert_date")
    private Date insertDate;

    @LastModifiedDate
    @Column(name = "last_modified")
    private Date lastUpdateDate;

    //mapping with "cities" entity
    @OneToMany
    @JoinColumn(name = "id")
    private List<City> cities = new ArrayList<>();

    //mapping with "country_lang" entity
    @OneToMany(cascade = CascadeType.ALL, targetEntity = CountryLanguage.class, mappedBy = "country")
    private List<CountryLanguage> languages = new ArrayList<>();

}
