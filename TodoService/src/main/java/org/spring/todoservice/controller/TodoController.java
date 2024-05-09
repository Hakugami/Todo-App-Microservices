package org.spring.todoservice.controller;

import org.spring.todoservice.models.TodoEntity;
import org.spring.todoservice.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todos")
public class TodoController {
    @Autowired
    private TodoService todoService;
    @PostMapping
    public ResponseEntity<TodoEntity> postTodo(@RequestBody TodoEntity todoEntity){
        todoService.createTodo(todoEntity);
        return new ResponseEntity<>(todoEntity, HttpStatus.CREATED);
    }
}
