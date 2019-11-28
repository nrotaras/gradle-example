package com.europe.europecountries.repositories;

import com.europe.europecountries.models.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface CityRepository extends JpaRepository<City, Long> {
}
