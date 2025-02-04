package com.LifeHub_Back.task.infrastructure.repository;

import com.LifeHub_Back.task.domain.entity.Label;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ILabelRepository extends JpaRepository<Label, Long> {
    Optional<Label> findByName(String name);
}
