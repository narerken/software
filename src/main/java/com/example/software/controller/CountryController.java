package com.example.software.controller;

import com.example.software.entity.Country;
import com.example.software.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/country")
public class CountryController {

    private final CountryService countryService;

    @GetMapping
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(countryService.getAll() , HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addCountry(@RequestBody Country country){
        countryService.addCountry(country);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCountry(@PathVariable(name = "id") Long id,
                                           @RequestBody Country country){
        countryService.updateCountry(id, country);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}