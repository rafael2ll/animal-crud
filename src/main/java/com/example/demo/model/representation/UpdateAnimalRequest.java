package com.example.demo.model.representation;

import com.example.demo.model.dto.UpdateAnimalDto;

public record UpdateAnimalRequest(String name, String description) {
    public UpdateAnimalDto toDto(){
        return new UpdateAnimalDto(name, description);
    }
}
