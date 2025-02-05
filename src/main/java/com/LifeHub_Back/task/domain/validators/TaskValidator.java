package com.LifeHub_Back.task.domain.validators;

import com.LifeHub_Back.task.application.dto.TaskDto;
import org.springframework.stereotype.Component;

@Component
public class TaskValidator {

    public static void validate(TaskDto taskDto) {
        if (taskDto.getName() == null || taskDto.getName().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }

        if (taskDto.getDescription() == null || taskDto.getDescription().isEmpty()) {
            throw new IllegalArgumentException("Description cannot be null or empty");
        }

        if (taskDto.getName().length() < 1 || taskDto.getName().length() > 255) {
            throw new IllegalArgumentException("Name must be between 1 and 255 characters.");
        }
    }
}
