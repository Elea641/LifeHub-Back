package com.LifeHub_Back.user.domain.service.interfaces;

import com.LifeHub_Back.user.domain.dto.UserDto;
import com.LifeHub_Back.user.domain.entity.User;

public interface IUserMapperService {
    UserDto toDto(User user);
}
