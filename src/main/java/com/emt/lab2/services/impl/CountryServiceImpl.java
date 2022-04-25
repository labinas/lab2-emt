package com.emt.lab2.services.impl;/*
    Created by Labina on 25-Apr-22
*/

import com.emt.lab2.model.Country;
import com.emt.lab2.repository.CountryRepository;
import com.emt.lab2.services.CountryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    @Override
    public void createCountry(Country country) {
        countryRepository.save(country);
    }

    @Override
    public Country findById(Long id) {
        return countryRepository.findById(id).get();
    }
}