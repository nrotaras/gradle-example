package com.europe.europecountries.controllers;

import com.europe.europecountries.exceptions.CountryNotFoundException;
import com.europe.europecountries.exceptions.NotLanguageFindException;
import com.europe.europecountries.models.CountryLanguage;
import com.europe.europecountries.repositories.CountryRepository;
import com.europe.europecountries.repositories.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/europe/countries")
public class LanguagesController {
    @Autowired
    private final LanguageRepository languageRepository;

    @Autowired
    private final CountryRepository countryRepository;

    public LanguagesController(LanguageRepository languageRepository, CountryRepository countryRepository) {
        this.languageRepository = languageRepository;
        this.countryRepository = countryRepository;
    }


    @GetMapping("/{countryId}/languages")
    public Page<CountryLanguage> findLanguageByCountryId(@PathVariable(value = "countryId") Integer countryId, Pageable pageable) {
        return languageRepository.findLanguageByCountryId(countryId, pageable);
    }

    @PostMapping("/{countryId}/languages")
    public CountryLanguage createLanguage(@PathVariable(value = "countryId") Integer countryId, @Valid @RequestBody CountryLanguage language) {
        return countryRepository.findById(countryId).map(country -> {
            language.setCountry(country);
            return languageRepository.save(language);
        }).orElseThrow(() -> new NotLanguageFindException());
    }

    @PutMapping("/{countryId}/languages/{languageId}")
    public CountryLanguage updateCountryLanguage(@PathVariable(value = "countryId") Integer countryId,
                                                 @PathVariable(value = "languageId") Integer languageId,
                                                 @Valid @RequestBody CountryLanguage language) {
        if (!countryRepository.existsById(countryId)) {
            throw new CountryNotFoundException();
        }

        return languageRepository.findById(languageId).map(language1 -> {
            language1.setLanguage(language.getLanguage());
            return languageRepository.save(language1);
        }).orElseThrow(() -> new NotLanguageFindException());
    }

}
