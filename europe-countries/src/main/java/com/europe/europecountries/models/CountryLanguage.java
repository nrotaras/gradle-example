package com.europe.europecountries.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "country_lang")
@Data
@NoArgsConstructor
public class CountryLanguage {

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    private Integer id;

    private String language;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Country.class)
    private Country country;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CountryLanguage language = (CountryLanguage) o;
        return Objects.equals(language, language.language);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(language);
    }

}
