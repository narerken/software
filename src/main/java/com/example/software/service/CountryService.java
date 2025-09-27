package com.example.software.service;

import com.example.software.entity.Country;

import java.util.List;

public interface CountryService{
    List<Country> getAll();
    void addCountry(Country country);
    void updateCountry(Long id, Country country);
    void deleteCountry(Long id);
}
