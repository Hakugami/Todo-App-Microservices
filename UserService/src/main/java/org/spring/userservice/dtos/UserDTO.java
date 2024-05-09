package org.spring.userservice.dtos;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserDTO implements Serializable {
    private String email;
    private String phone;
    private String username;
    private String password;
}
