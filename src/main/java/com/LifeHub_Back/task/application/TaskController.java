package com.LifeHub_Back.task.application;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @GetMapping("/")
    public ResponseEntity<?> getTasksByUser () {
        try {
            return ResponseEntity.ok().body("task");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
