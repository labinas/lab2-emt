package com.emt.lab2.services;/*
    Created by Labina on 25-Apr-22
*/

import com.emt.lab2.model.Country;

public interface CountryService {
    void createCountry(Country country);

    Country findById(Long id);
}

