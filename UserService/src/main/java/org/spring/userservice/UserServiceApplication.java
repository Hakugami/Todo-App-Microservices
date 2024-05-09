package org.spring.userservice;

import org.spring.userservice.models.UserEntity;
import org.spring.userservice.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(UserService userService) {
        return args -> {
            UserEntity user = new UserEntity();
            user.setUsername("user");
            user.setEmail("bogus@bogus.com");
            user.setPassword("password");
            user.setPhone("123456789");
            userService.createUser(user);
        };
    }

}
