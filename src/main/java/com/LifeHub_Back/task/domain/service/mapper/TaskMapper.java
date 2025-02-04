package com.LifeHub_Back.task.domain.service.mapper;

import com.LifeHub_Back.task.domain.dto.TaskDto;
import com.LifeHub_Back.task.domain.entity.Label;
import com.LifeHub_Back.task.domain.entity.Task;
import com.LifeHub_Back.task.infrastructure.repository.ILabelRepository;
import com.LifeHub_Back.user.domain.entity.User;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class TaskMapper {

    private final LabelMapper labelMapper;
    private final ILabelRepository labelRepository;

    public TaskMapper(LabelMapper labelMapper, ILabelRepository labelRepository) {
        this.labelMapper = labelMapper;
        this.labelRepository = labelRepository;
    }

    public Task toEntity(TaskDto taskDto, User user) {
        if (taskDto == null) {
            throw new IllegalArgumentException("taskDto cannot be null");
        }
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }

        Task task = new Task();
        task.setName(taskDto.getName());
        task.setDescription(taskDto.getDescription());
        task.setCreatedAt(taskDto.getCreatedAt());
        task.setDeadLine(taskDto.getDeadLine());
        task.setStartDate(taskDto.getStartDate());
        task.setEndDate(taskDto.getEndDate());
        task.setUpdatedAt(taskDto.getUpdatedAt());
        task.setUser(user);

        Set<Label> labels = taskDto.getLabels()
                .stream()
                .map(labelDto -> {
                    Label label = labelMapper.toEntity(labelDto);

                    if (label.getId() == null) {
                        labelRepository.save(label);
                    }

                    return label;
                })
                .collect(Collectors.toSet());

        task.setLabels(labels);

        return task;
    }

    public TaskDto toDto(Task task) {
        TaskDto dto = new TaskDto(
                task.getName(),
                task.getDescription(),
                task.getCreatedAt(),
                task.getDeadLine(),
                task.getStartDate(),
                task.getEndDate(),
                task.getUpdatedAt(),
                task.getLabels()
                        .stream()
                        .map(labelMapper::toDto)
                        .collect(Collectors.toList())
        );

        return dto;
    }
}
