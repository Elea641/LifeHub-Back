package com.LifeHub_Back.task.application.dto;

public class TaskDto {
    private String name;
    private String description;

    public TaskDto(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
