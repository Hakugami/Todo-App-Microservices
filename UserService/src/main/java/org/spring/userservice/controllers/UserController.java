package org.spring.userservice.controllers;


import org.spring.userservice.dtos.UserDTO;
import org.spring.userservice.mappers.UserMapper;
import org.spring.userservice.models.UserEntity;
import org.spring.userservice.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDto) {
        UserEntity user = userMapper.toUserEntity(userDto);
        userService.createUser(user);
        return new ResponseEntity<>(userMapper.toUserDTO(user), HttpStatus.CREATED);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable String id) {
        UserEntity user = userService.getUser(id);
        return user != null ? new ResponseEntity<>(userMapper.toUserDTO(user), HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{email}")
    public ResponseEntity<UserDTO> getUserByEmail(@PathVariable String email) {
        UserEntity user = userService.getUserByEmail(email);
        return user != null ? new ResponseEntity<>(userMapper.toUserDTO(user), HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable String id, @RequestBody UserDTO userDto) {
        Optional<UserEntity> userData = Optional.ofNullable(userService.getUser(id));

        if (userData.isPresent()) {
            UserEntity userEntity = userData.get();
            userEntity.setUsername(userDto.getUsername());
            userEntity.setEmail(userDto.getEmail());
            userEntity.setPhone(userDto.getPhone());

            userService.updateUser(userEntity);
            return new ResponseEntity<>(userMapper.toUserDTO(userEntity), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable String id) {
        try {
            userService.deleteUser(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
