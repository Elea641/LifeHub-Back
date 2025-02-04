package com.LifeHub_Back.task.domain.service.interfaces;

import com.LifeHub_Back.task.domain.dto.TaskDto;
import com.LifeHub_Back.task.domain.entity.Task;

import java.util.List;
import java.util.Optional;

public interface ITaskService {
    Task createTask(TaskDto taskDto);
    List<Task> getAllTasks();
    Optional<Task> getTaskById(Long id);
    Task updateTask(Long id, Task task);
    void deleteTask(Long id);
}
