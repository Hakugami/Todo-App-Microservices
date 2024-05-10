package org.spring.todoservice.controller;

import lombok.RequiredArgsConstructor;
import org.spring.todoservice.dtos.TaskDTO;
import org.spring.todoservice.dtos.TodoDTO;
import org.spring.todoservice.mappers.TaskMapper;
import org.spring.todoservice.mappers.TodoMapper;
import org.spring.todoservice.models.TaskEntity;
import org.spring.todoservice.models.TodoEntity;
import org.spring.todoservice.service.TodoService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todos")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;
    private final TaskMapper taskMapper;
    private final TodoMapper todoMapper;
    @Value("${profile.name}")
    private String profileName;

    @PostMapping
    public ResponseEntity<TodoEntity> postTodo(@RequestBody TodoDTO todoDTO) {
        TodoEntity todoEntity = todoMapper.toEntity(todoDTO);
        todoService.createTodo(todoEntity);
        return new ResponseEntity<>(todoEntity, HttpStatus.CREATED);
    }

    @PostMapping("/add-task")
    public ResponseEntity<TaskEntity> addTask(@RequestBody TaskDTO taskDTO) {
        TaskEntity taskEntity = taskMapper.taskDTOToTaskEntity(taskDTO);
        todoService.addTask(taskEntity, taskDTO.getEmail());
        ResponseEntity<String> stringResponseEntity = todoService.sendNotification(taskDTO);

        if (stringResponseEntity.getStatusCode().is2xxSuccessful())
            return new ResponseEntity<>(taskEntity, HttpStatus.CREATED);
        else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping
    public ResponseEntity<TodoDTO> getTodo(String email) {
        TodoDTO todoDTO = todoService.getTodo(email);
        System.out.println("in the profile : "+profileName);
        return new ResponseEntity<>(todoDTO, HttpStatus.OK);
    }
}
