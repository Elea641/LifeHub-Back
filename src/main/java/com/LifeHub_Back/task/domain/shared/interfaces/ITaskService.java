package com.LifeHub_Back.task.domain.shared.interfaces;

import com.LifeHub_Back.task.application.dto.TaskDto;
import com.LifeHub_Back.task.domain.entity.Task;

import java.util.List;

public interface ITaskService {

    List<Task> getAllTasks();

    Task getTaskById(Long id);

    Task createTask(TaskDto taskDto);
}
