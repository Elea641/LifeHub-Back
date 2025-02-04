package com.LifeHub_Back.task.domain.entity;

import com.LifeHub_Back.task.domain.validators.IFieldValidator;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Label implements IFieldValidator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name",unique = true)
    private String name;
    @Column(name = "color", unique = true)
    private String color;

    @ManyToMany(mappedBy = "labels")
    private Set<Task> tasks = new HashSet<>();

    public Label() {};

    public Label(String name, String color) {
        this.name = name;
        this.color = color;
        this.validate();
    }

    @Override
    public void validate() {
        if (name == null || name.length() < 1 || name.length() > 255) {
            throw new IllegalArgumentException("Name must be between 1 and 255 characters.");
        }
        if (color == null || color.trim().isEmpty()) {
            throw new IllegalArgumentException("Color cannot be null or empty.");
        }
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }
}
