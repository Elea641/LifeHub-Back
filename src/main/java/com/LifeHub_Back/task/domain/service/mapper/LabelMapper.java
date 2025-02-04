package com.LifeHub_Back.task.domain.service.mapper;

import com.LifeHub_Back.task.domain.dto.LabelDto;
import com.LifeHub_Back.task.domain.entity.Label;
import org.springframework.stereotype.Component;

@Component
public class LabelMapper {

    public Label toEntity(LabelDto labelDto) {
        Label label = new Label();
        label.setName(labelDto.getName());
        label.setColor(labelDto.getColor());
        return label;
    }

    public LabelDto toDto(Label label) {
        LabelDto labelDto = new LabelDto();
        labelDto.setName(label.getName());
        labelDto.setColor(label.getColor());
        return labelDto;
    }
}