package org.spring.todoservice.dtos;

import lombok.Data;
import org.spring.todoservice.models.TaskEntity;
import java.util.List;

@Data
public class TodoDTO {
    private String id;
    private String title;
    private String email;
    private List<TaskEntity> taskEntity;
}
