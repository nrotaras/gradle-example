package com.europe.europecountries.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "country_lang")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CountryLanguage {

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    private Integer id;

    private String language;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Country country;

}
