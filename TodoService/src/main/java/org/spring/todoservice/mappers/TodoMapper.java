package org.spring.todoservice.mappers;

import org.mapstruct.Mapper;
import org.spring.todoservice.dtos.TodoDTO;
import org.spring.todoservice.models.TodoEntity;

@Mapper(componentModel = "spring")
public interface TodoMapper {
    TodoEntity toEntity(TodoDTO todoDTO);
    TodoDTO toDTO(TodoEntity todoEntity);
}
