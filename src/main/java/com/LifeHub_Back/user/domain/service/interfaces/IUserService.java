package com.LifeHub_Back.user.domain.service.interfaces;

import com.LifeHub_Back.user.domain.dto.UserDto;

import java.util.List;

public interface IUserService {

    List<UserDto> getAllUsers() throws Exception;

    UserDto getCurrentUser() throws Exception;
}
