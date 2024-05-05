package org.spring.userservice.models;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collection = "users")
@Data
public class UserEntity {
    @MongoId
    private String id;
    private String username;
    private String email;
    private String password;
    private String phone;

}
