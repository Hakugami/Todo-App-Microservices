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

    public UserEntity getUser(String id) {
        return userRepository.findById(id).orElse(null);
    }

    public void updateUser(UserEntity user) {
        userRepository.save(user);
    }

    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }

    public UserEntity getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }




}
