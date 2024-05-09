package org.spring.todoservice.mappers;

import org.mapstruct.Mapper;
import org.spring.todoservice.dtos.TaskDTO;
import org.spring.todoservice.models.TaskEntity;

@Mapper(componentModel = "spring")
public interface TaskMapper {
    TaskDTO taskEntityToTaskDTO(TaskEntity taskEntity);

    TaskEntity taskDTOToTaskEntity(TaskDTO taskDTO);
}
