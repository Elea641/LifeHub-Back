package com.LifeHub_Back.user.domain.service.interfaces;

import com.LifeHub_Back.user.domain.dto.UserDto;
import com.LifeHub_Back.user.domain.entity.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    List<UserDto> getAllUsers() throws Exception;

    UserDto getCurrentUser() throws Exception;
}
