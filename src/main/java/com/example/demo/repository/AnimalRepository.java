package com.example.demo.repository;

import com.example.demo.model.entity.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListPagingAndSortingRepository;

public interface AnimalRepository extends ListPagingAndSortingRepository<Animal, Integer>, CrudRepository<Animal, Integer> {
    boolean existsByName(String name);
}
