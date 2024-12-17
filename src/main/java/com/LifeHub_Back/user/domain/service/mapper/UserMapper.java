package com.LifeHub_Back.user.domain.service.mapper;

import com.LifeHub_Back.user.domain.dto.UserDto;
import com.LifeHub_Back.user.domain.entity.User;
import com.LifeHub_Back.user.domain.service.interfaces.IUserMapperService;
import org.springframework.stereotype.Service;

@Service
public class UserMapper implements IUserMapperService {

    public UserDto toDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        return userDto;
    }
}
