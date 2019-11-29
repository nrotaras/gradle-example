package com.europe.europecountries.repositories;

import com.europe.europecountries.models.CountryLanguage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface LanguageRepository extends JpaRepository<CountryLanguage, Integer> {
    Page<CountryLanguage> findLanguageByCountryId(Integer id, Pageable pageable);
}
