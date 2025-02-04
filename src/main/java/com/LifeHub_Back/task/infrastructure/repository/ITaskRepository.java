package com.LifeHub_Back.task.infrastructure.repository;

import com.LifeHub_Back.task.domain.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITaskRepository extends JpaRepository<Task, Long> {
}
