package com.LifeHub_Back.task.domain.service;


import com.LifeHub_Back.task.domain.dto.TaskDto;
import com.LifeHub_Back.task.domain.entity.Task;
import com.LifeHub_Back.task.domain.service.interfaces.ITaskService;
import com.LifeHub_Back.task.infrastructure.repository.ITaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService implements ITaskService {

    private final ITaskRepository taskRepository;

    @Autowired
    public TaskService(ITaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


    @Override
    public Task createTask(TaskDto taskDto) {
        return null;
    }

    @Override
    public List<Task> getAllTasks() {
        return List.of();
    }

    @Override
    public Optional<Task> getTaskById(Long id) {
        return Optional.empty();
    }

    @Override
    public Task updateTask(Long id, Task task) {
        return null;
    }

    @Override
    public void deleteTask(Long id) {

    }

}

