package com.LifeHub_Back.Entity;

import com.LifeHub_Back.task.domain.entity.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class TaskEntityTest {

   private Task task;
   private String name;
   private String description;
   private LocalDateTime createdAt;
   private LocalDateTime updatedAt;

    @BeforeEach
    public void setUp() {
        name = "Task 1";
        description = "Task description";
        task = new Task.Builder()
                .setName(name)
                .setDescription(description)
                .build();
    }

    @Test
    public void test_Task_Creation() {
        assertNotNull(task, "Task should be created");
        assertEquals(name, task.getName(), "Task name should match");
        assertEquals(description, task.getDescription(), "Task description should match");
        assertNotNull(task.getCreatedAt(), "CreatedAt should not be null");
        assertNotNull(task.getUpdatedAt(), "UpdatedAt should not be null");
    }
}
