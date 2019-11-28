package com.europe.europecountries.controllers;

import com.europe.europecountries.models.CountryLanguage;
import com.europe.europecountries.repositories.CityRepository;
import com.europe.europecountries.models.Country;
import com.europe.europecountries.repositories.CountryRepository;
import com.europe.europecountries.repositories.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/europe")
public class CountriesController {

    @Autowired
    private final CountryRepository countryRepository;

    @Autowired
    private final CityRepository cityRepository;

    @Autowired
    private final LanguageRepository langRepository;

    public CountriesController(CountryRepository countryRepository, CityRepository cityRepository, LanguageRepository langRepository) {
        this.countryRepository = countryRepository;
        this.cityRepository = cityRepository;
        this.langRepository = langRepository;
    }

    @GetMapping("/countries")
    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    @PutMapping("/countries/")
    public Country addCountry(@RequestBody Country newCountry){
        newCountry.getLanguages().get(0).getCountry();
        return countryRepository.save(newCountry);
    }


   /* @PutMapping("/countries/{id}")
    public Country updateCountry(@RequestBody Country newCountry, @PathVariable Long id) {


        Country updatedCountry = countryRepository.findById(id)
                .map(country -> {
                    country.setCode(newCountry.getCode());
                    country.setName(newCountry.getName());
                    country.setRegion(newCountry.getRegion());
                    country.setPopulation(newCountry.getPopulation());
                    country.setSurfaceArea(newCountry.getSurfaceArea());
                    // country.setLanguages(langs);
                    return countryRepository.save(country);
                }).orElseGet(
                        () -> {
//                            newCountry.setId(id);
//                            langRepository.save(newCountry.getLanguages().get(0));
                            CountryLanguage c = new CountryLanguage();
                            c.setLanguage("asdasd");

                            langRepository.save(c);
                            newCountry.getLanguages().add(c);
                            return countryRepository.save(newCountry);
                        });


//        List<CountryLanguage> langs = newCountry.getLanguages();
//        for (CountryLanguage lang : langs){
//            //lang.setCountry(updatedCountry);
//            langRepository.save(lang);
//        }
        return updatedCountry;
    }*/

    @GetMapping("/languages")
    public List<CountryLanguage> allLanguages() {
        return langRepository.findAll();
    }

}
