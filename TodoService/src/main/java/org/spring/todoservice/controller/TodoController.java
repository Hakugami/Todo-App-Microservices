package org.spring.todoservice.controller;

import org.spring.todoservice.models.TaskEntity;
import org.spring.todoservice.models.TodoEntity;
import org.spring.todoservice.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todos")
public class TodoController {
    @Autowired
    private TodoService todoService;
    @PostMapping("/add-todo")
    public ResponseEntity<TodoEntity> postTodo(@RequestBody TodoEntity todoEntity){
        todoService.createTodo(todoEntity);
        return new ResponseEntity<>(todoEntity, HttpStatus.CREATED);
    }

    @PostMapping("/add-task")
    public ResponseEntity<TaskEntity> addTask(@RequestBody TaskEntity taskEntity, String email){
        todoService.addTask(taskEntity, email);
        return new ResponseEntity<>(taskEntity, HttpStatus.CREATED);
    }

    @GetMapping("{email}")
    public ResponseEntity<TodoEntity> getTodo(@PathVariable String email){
        TodoEntity todoEntity = todoService.getTodo(email);
        return new ResponseEntity<>(todoEntity, HttpStatus.FOUND);
    }
}
