package com.europe.europecountries.controllers;

import com.europe.europecountries.exceptions.CountryNotFoundException;
import com.europe.europecountries.models.Country;
import com.europe.europecountries.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/europe")
public class CountriesController {

    @Autowired
    private final CountryRepository countryRepository;

    public CountriesController(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    //GET all Countries from a list
    @GetMapping("/countries")
    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    @GetMapping("/countries/{countryId}")
    Country oneCountry(@PathVariable Integer countryId) {
        return countryRepository.findById(countryId).orElseThrow(() -> new CountryNotFoundException());
    }

    //POST a new Country object
    @PostMapping("/countries")
    public Country addCountry(@Valid @RequestBody Country newCountry) {
        return countryRepository.save(newCountry);
    }

    // PUT another information about one country
    @PutMapping("/countries/{countryId}")
    public Country updateCountry(@PathVariable Integer countryId, Country upCountry) {
        return countryRepository.findById(countryId).map(country -> {
            country.setCode(upCountry.getCode());
            country.setName(upCountry.getName());
            country.setRegion(upCountry.getRegion());
            country.setPopulation(upCountry.getPopulation());
            country.setSurfaceArea(upCountry.getSurfaceArea());
            return countryRepository.save(country);
        }).orElseThrow(() -> new CountryNotFoundException());
    }

    @DeleteMapping("/countries/{countryId}")
    public void deleteCountry(@PathVariable Integer countryId) {
        if (countryRepository.existsById(countryId)) {
            countryRepository.deleteById(countryId);
        }

    }

}
