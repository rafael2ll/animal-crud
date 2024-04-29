package com.example.demo.api.controller;

import com.example.demo.model.entity.Animal;
import com.example.demo.model.representation.AnimalResponse;
import com.example.demo.model.representation.CreateAnimalRequest;
import com.example.demo.model.representation.UpdateAnimalRequest;
import com.example.demo.service.AnimalService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/animals")
public class AnimalController {
    private final AnimalService animalService;
    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }
    @PostMapping
    public AnimalResponse create(@RequestBody CreateAnimalRequest animal) {
        return AnimalResponse.fromDto(animalService.create(animal.toDto()));
    }

    @GetMapping("/{id}")
    public AnimalResponse findById(@PathVariable("id") Integer id) {
        return AnimalResponse.fromDto(animalService.findById(id));
    }

    @GetMapping
    public List<AnimalResponse> getAnimals(@RequestParam int page) {
        return animalService.findAllPaged(page).stream().map(AnimalResponse::fromDto).toList();
    }

    @PutMapping("/{id}")
    public AnimalResponse update(@PathVariable("id") Integer id, @RequestBody UpdateAnimalRequest animal) {
        return AnimalResponse.fromDto(animalService.update(id, animal.toDto()));
    }

    @DeleteMapping
    public void delete(@RequestParam Integer id) {
        animalService.delete(id);
    }
}
