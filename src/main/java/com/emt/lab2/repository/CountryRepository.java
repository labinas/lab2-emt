package com.emt.lab2.repository;/*
    Created by Labina on 25-Apr-22
*/

import com.emt.lab2.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
