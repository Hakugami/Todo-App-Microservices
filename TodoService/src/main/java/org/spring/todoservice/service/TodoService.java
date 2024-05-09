package org.spring.todoservice.service;

import org.spring.todoservice.models.TodoEntity;
import org.spring.todoservice.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;
    public void saveTodo(TodoEntity todoEntity){
        todoRepository.save(todoEntity);
    }

    public void createTodo(TodoEntity todoEntity){
        todoRepository.insert(todoEntity);
    }
}
