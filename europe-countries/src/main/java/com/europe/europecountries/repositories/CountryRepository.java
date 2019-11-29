package com.europe.europecountries.repositories;

import com.europe.europecountries.models.Country;
import com.europe.europecountries.models.CountryLanguage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface CountryRepository extends JpaRepository<Country, Integer> {

}
