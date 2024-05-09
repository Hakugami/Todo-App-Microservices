package org.spring.todoservice.dtos;

import lombok.Data;
import org.spring.todoservice.models.TaskEntity;

import java.io.Serializable;
import java.util.List;

@Data
public class TodoDTO implements Serializable {

    private String title;
    private String email;
    private List<TaskEntity> taskEntity;
}
