package com.example.demo.model.dto;

import com.example.demo.model.entity.Animal;

public record CreateAnimalDto(String name, String description) {
    public Animal toEntity(){
        return new Animal(0, name, description);
    }
}
