package org.spring.userservice.mappers;

import org.mapstruct.Mapping;
import org.spring.userservice.dtos.UserDTO;
import org.spring.userservice.models.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper{
    UserDTO toUserDTO(UserEntity userEntity);
    UserEntity toUserEntity(UserDTO userDTO);
}
