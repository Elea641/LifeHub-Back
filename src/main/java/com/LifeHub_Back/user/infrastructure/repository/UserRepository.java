package com.LifeHub_Back.user.infrastructure.repository;

import com.LifeHub_Back.user.infrastructure.interfaces.IUserRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public interface UserRepository extends IUserRepository {
}
