package org.spring.todoservice.service;

import lombok.RequiredArgsConstructor;
import org.spring.todoservice.models.TaskEntity;
import org.spring.todoservice.models.TodoEntity;
import org.spring.todoservice.repository.TaskRepository;
import org.spring.todoservice.repository.TodoRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;
    private final TaskRepository taskRepository;


    public void saveTodo(TodoEntity todoEntity) {
        todoRepository.save(todoEntity);
    }

    public void createTodo(TodoEntity todoEntity) {
        todoRepository.insert(todoEntity);
    }

    public void addTask(TaskEntity taskEntity, String email) {
        TodoEntity todoEntity = todoRepository.findByEmail(email);
        TaskEntity savedTaskEntity = taskRepository.save(taskEntity);
        todoEntity.getTaskEntity().add(savedTaskEntity);
        todoRepository.save(todoEntity);
    }

    public TodoEntity getTodo(String email) {
        return todoRepository.findByEmail(email);
    }
}
