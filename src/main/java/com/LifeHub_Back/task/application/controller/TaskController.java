package com.LifeHub_Back.task.application.controller;

import com.LifeHub_Back.task.domain.service.interfaces.ITaskService;
import com.LifeHub_Back.task.domain.service.mapper.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final ITaskService taskService;
    private final TaskMapper taskMapper;

    @Autowired
    public TaskController(ITaskService taskService, TaskMapper taskMapper) {
        this.taskService = taskService;
        this.taskMapper = taskMapper;
    }
}
