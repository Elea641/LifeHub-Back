package com.LifeHub_Back.task.domain.shared;

import com.LifeHub_Back.task.application.dto.TaskDto;
import com.LifeHub_Back.task.domain.entity.Task;
import com.LifeHub_Back.task.domain.shared.exception.TaskValidationException;
import com.LifeHub_Back.task.domain.shared.interfaces.ITaskService;
import com.LifeHub_Back.task.domain.validators.TaskValidator;
import com.LifeHub_Back.task.infrastructure.repository.ITaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService implements ITaskService {

    private final ITaskRepository taskRepository;
    private final TaskValidator taskValidator;

    @Autowired
    public TaskService(ITaskRepository taskRepository, TaskValidator taskValidator) {
        this.taskRepository = taskRepository;
        this.taskValidator = taskValidator;
    }

    @Override
    public Task createTask(TaskDto taskDto) {
        taskValidator.validate(taskDto);

        Task createTask = new Task.Builder()
                .setName(taskDto.getName())
                .setDescription(taskDto.getDescription())
                .build();

        taskRepository.save(createTask);
        return createTask;
    }

    public List<Task> getAllTasks() {
        List<Task> tasks = taskRepository.findAll();

        if (tasks.isEmpty()) {
            throw new TaskValidationException("No tasks found");
        }

        return tasks;
    }

    public Task getTaskById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new TaskValidationException("Task with ID " + id + " not found"));
    }
}

