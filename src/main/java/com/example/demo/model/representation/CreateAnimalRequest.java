package com.example.demo.model.representation;

import com.example.demo.model.dto.CreateAnimalDto;

public record CreateAnimalRequest(String name, String description) {
    public CreateAnimalDto toDto(){
        return new CreateAnimalDto( name, description);
    }
}
