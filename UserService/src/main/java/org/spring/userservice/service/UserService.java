package org.spring.userservice.service;


import lombok.RequiredArgsConstructor;
import org.spring.userservice.models.UserEntity;
import org.spring.userservice.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void createUser(UserEntity user) {
        userRepository.save(user);
    }
}
