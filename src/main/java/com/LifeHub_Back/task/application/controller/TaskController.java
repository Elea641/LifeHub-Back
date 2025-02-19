package com.LifeHub_Back.task.application.controller;

import com.LifeHub_Back.configuration.application.shared.dto.ErrorResponse;
import com.LifeHub_Back.task.application.dto.TaskDto;
import com.LifeHub_Back.task.domain.entity.Task;
import com.LifeHub_Back.task.domain.shared.exception.TaskValidationException;
import com.LifeHub_Back.task.domain.shared.interfaces.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final ITaskService taskService;

    @Autowired
    public TaskController(ITaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/")
    public ResponseEntity<?> createTask(@RequestBody TaskDto taskDto) {
        try {
            Task createdTask = taskService.createTask(taskDto);
            return new ResponseEntity<>(createdTask, HttpStatus.CREATED);
        } catch (TaskValidationException e) {
            ErrorResponse errorResponse = new ErrorResponse("Validation error", e.getMessage());
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            ErrorResponse errorResponse = new ErrorResponse("An unexpected error occurred", e.getMessage());
            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllTasks() {
        try {
            List<Task> tasks = taskService.getAllTasks();

            return new ResponseEntity<>(tasks, HttpStatus.OK);

        } catch (TaskValidationException e) {
            ErrorResponse errorResponse = new ErrorResponse("Validation error", e.getMessage());
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            ErrorResponse errorResponse = new ErrorResponse("An unexpected error occurred", e.getMessage());
            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTask(@PathVariable Long id) {
        try {
            Task createdTask = taskService.getTaskById(id);
            return new ResponseEntity<>(createdTask, HttpStatus.OK);
        } catch (TaskValidationException e) {
            ErrorResponse errorResponse = new ErrorResponse("Validation error", e.getMessage());
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            ErrorResponse errorResponse = new ErrorResponse("An unexpected error occurred", e.getMessage());
            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
