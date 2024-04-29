package com.example.demo.model.representation;


import com.example.demo.model.dto.AnimalDto;
import com.example.demo.model.entity.Animal;

import java.util.Date;

public record AnimalResponse(Integer id, String name, String description, Date createdAt) {
    public static AnimalResponse fromDto(AnimalDto animal) {
        return new AnimalResponse(animal.id(), animal.name(), animal.description(), animal.createdAt());
    }
}