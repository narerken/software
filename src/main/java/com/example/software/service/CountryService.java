package com.example.software.service;

import com.example.software.dto.CountryDto;
import com.example.software.entity.Country;

import java.util.List;

public interface CountryService{
    List<CountryDto> getAll();
    void addCountry(Country country);
    void updateCountry(Long id, Country country);
    void deleteCountry(Long id);
}
