package com.example.demo.model.dto;

import com.example.demo.model.entity.Animal;

import java.util.Date;

public record AnimalDto(Integer id, String name, String description, Date createdAt) {
    public static AnimalDto fromEntity(Animal animal) {
            return new AnimalDto(animal.getId(), animal.getName(), animal.getDescription(), animal.getCreatedAt());
    }
}
