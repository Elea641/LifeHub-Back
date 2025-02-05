package com.LifeHub_Back.task.domain.shared.interfaces;

import com.LifeHub_Back.task.application.dto.TaskDto;
import com.LifeHub_Back.task.domain.entity.Task;

public interface ITaskService {
    Task createTask(TaskDto taskDto);
}
