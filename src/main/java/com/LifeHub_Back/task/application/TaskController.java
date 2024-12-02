package com.LifeHub_Back.task.application;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @GetMapping("/")
    public ResponseEntity<?> getTasksByUser () {
        try {
            Map<String, String> response = new HashMap<>();
            response.put("task", "Example task");

            return ResponseEntity.ok().body(response);        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
