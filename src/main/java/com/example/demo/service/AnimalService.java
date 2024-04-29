package com.example.demo.service;

import com.example.demo.model.dto.AnimalDto;
import com.example.demo.model.dto.CreateAnimalDto;
import com.example.demo.model.dto.UpdateAnimalDto;

import java.util.List;

public interface AnimalService {
    AnimalDto create(CreateAnimalDto createAnimalDto);
    AnimalDto findById(Integer id);
    List<AnimalDto> findAllPaged(int page);
    AnimalDto update(Integer id, UpdateAnimalDto updateAnimalDto);
    void delete(Integer id);
}
