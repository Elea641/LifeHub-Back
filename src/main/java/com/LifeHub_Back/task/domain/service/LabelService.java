package com.LifeHub_Back.task.domain.service;

import com.LifeHub_Back.task.domain.entity.Label;
import com.LifeHub_Back.task.infrastructure.repository.ILabelRepository;
import org.springframework.stereotype.Service;

@Service
public class LabelService {
    private final ILabelRepository labelRepository;

    public LabelService(ILabelRepository labelRepository) {
        this.labelRepository = labelRepository;
    }

    public Label getOrCreateLabel(String name, String color) {
        return labelRepository.findByName(name)
                .orElseGet(() -> {
                    Label newLabel = new Label(name, color);
                    return labelRepository.save(newLabel);
                });
    }
}
