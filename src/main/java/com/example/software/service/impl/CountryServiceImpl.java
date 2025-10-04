package com.example.software.service.impl;

import com.example.software.dto.CategoryDto;
import com.example.software.dto.CountryDto;
import com.example.software.entity.Category;
import com.example.software.entity.Country;
import com.example.software.repository.CategoryRepository;
import com.example.software.repository.CountryRepository;
import com.example.software.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;
    private final CategoryRepository categoryRepository;

    private CountryDto toDto(Country country){
        CountryDto countryDto = new CountryDto();
        countryDto.setId(country.getId());
        countryDto.setName(country.getName());
        return countryDto;
    }

    @Override
    public List<CountryDto> getAll() {
        List<Country> countries = countryRepository.findAll();
        List<CountryDto> result = new ArrayList<>();
        for(Country country : countries){
            result.add(toDto(country));
        }
        return result;
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
