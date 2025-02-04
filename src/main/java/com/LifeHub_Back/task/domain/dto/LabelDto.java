package com.LifeHub_Back.task.domain.dto;

import jakarta.persistence.Column;

public class LabelDto {
    private String name;
    private String color;

    public LabelDto(){};

    public LabelDto(String name, String color) {
        this.name = name;
        this.color = color;
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
}
