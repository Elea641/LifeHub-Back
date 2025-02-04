package com.LifeHub_Back.task.domain.service;


import com.LifeHub_Back.task.domain.dto.TaskDto;
import com.LifeHub_Back.task.domain.entity.Task;
import com.LifeHub_Back.task.domain.service.interfaces.ITaskService;
import com.LifeHub_Back.task.domain.service.mapper.TaskMapper;
import com.LifeHub_Back.task.infrastructure.repository.ITaskRepository;
import com.LifeHub_Back.user.domain.dto.UserDto;
import com.LifeHub_Back.user.domain.entity.User;
import com.LifeHub_Back.user.domain.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService implements ITaskService {

    private final ITaskRepository taskRepository;
    private final IUserService userService;
    private final TaskMapper taskMapper;

    @Autowired
    public TaskService(ITaskRepository taskRepository, IUserService userService, TaskMapper taskMapper) {
        this.taskRepository = taskRepository;
        this.userService = userService;
        this.taskMapper = taskMapper;
    }

    @Override
    public Task createTask(TaskDto taskDto) {
        UserDto userDto;
        try {
            userDto = userService.getCurrentUser();
        } catch (Exception e) {
            throw new IllegalArgumentException("Impossible de récupérer l'utilisateur actuel.", e);
        }

        if (userDto == null) {
            throw new IllegalArgumentException("Utilisateur non trouvé.");
        }

        User user = new User();
        user.setId(userDto.getId());

        Task task = taskMapper.toEntity(taskDto, user);

        return taskRepository.save(task);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    @Override
    public Task updateTask(Long id, Task task) {
        if (!taskRepository.existsById(id)) {
            throw new IllegalArgumentException("Task not found");
        }
        task.setId(id);
        return taskRepository.save(task);
    }

    @Override
    public void deleteTask(Long id) {
        if (!taskRepository.existsById(id)) {
            throw new IllegalArgumentException("Task not found");
        }
        taskRepository.deleteById(id);
    }
}

