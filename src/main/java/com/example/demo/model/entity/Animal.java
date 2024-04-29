package com.example.demo.model.entity;

import jakarta.persistence.*;

import java.util.Date;

@Table(name = "animal")
@Entity
public class Animal {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(unique = true)
    private String name;
    private String description;
    private Date createdAt;

    public Animal(){}
    public Animal(Integer id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.createdAt = new Date();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
