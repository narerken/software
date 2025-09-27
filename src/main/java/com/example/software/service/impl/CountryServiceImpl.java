package com.example.software.service.impl;

import com.example.software.entity.Country;
import com.example.software.repository.CountryRepository;
import com.example.software.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    @Override
    public List<Country> getAll() {
        return countryRepository.findAll();
    }

    @Override
    public void addCountry(Country country) {
        countryRepository.save(country);
    }

    @Override
    public void updateCountry(Long id, Country country) {
        Country update = countryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Country not found"));

        update.setName(country.getName());
        update.setCode(country.getCode());

        countryRepository.save(update);
    }

    @Override
    public void deleteCountry(Long id) {
        countryRepository.deleteById(id);
    }
}
