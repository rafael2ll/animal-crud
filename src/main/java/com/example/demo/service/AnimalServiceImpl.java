package com.example.demo.service;

import com.example.demo.exception.BusinessError;
import com.example.demo.exception.ConflictError;
import com.example.demo.exception.NotFoundError;
import com.example.demo.model.dto.AnimalDto;
import com.example.demo.model.dto.CreateAnimalDto;
import com.example.demo.model.dto.UpdateAnimalDto;
import com.example.demo.repository.AnimalRepository;
import org.hibernate.query.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalServiceImpl implements AnimalService {
    private AnimalRepository animalRepository;

    public AnimalServiceImpl(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @Override
    public AnimalDto create(CreateAnimalDto createAnimalDto) {
        var alreadyExists = animalRepository.existsByName(createAnimalDto.name());
        if (alreadyExists) {
            throw new ConflictError(String.format("um animal com nome de %s já existe", createAnimalDto.name()));
        }

        var animal = animalRepository.save(createAnimalDto.toEntity());
        return AnimalDto.fromEntity(animal);
    }

    @Override
    public AnimalDto findById(Integer id) {
        var animal = animalRepository.findById(id).orElseThrow(()-> new NotFoundError("animal não encontrado"));
        return AnimalDto.fromEntity(animal);
    }

    @Override
    public List<AnimalDto> findAllPaged(int page) {
        var animals = animalRepository.findAll((Pageable) Page.page(20, page));
        return animals.get().map(AnimalDto::fromEntity).toList();
    }

    @Override
    public AnimalDto update(Integer id, UpdateAnimalDto updateAnimalDto) {
        var animal = animalRepository.findById(id).orElseThrow(()-> new NotFoundError("animal não encontrado"));
        animal.setName(updateAnimalDto.name());
        animal.setDescription(updateAnimalDto.description());
        var updatedAnimal = animalRepository.save(animal);
        return AnimalDto.fromEntity(animal);
    }

    @Override
    public void delete(Integer id) {
        animalRepository.findById(id).orElseThrow(()-> new NotFoundError("animal não encontrado"));
        animalRepository.deleteById(id);
    }
}
