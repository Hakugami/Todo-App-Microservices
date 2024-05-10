package org.spring.todoservice.service;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import lombok.RequiredArgsConstructor;
import org.spring.todoservice.dtos.TaskDTO;
import org.spring.todoservice.dtos.TodoDTO;
import org.spring.todoservice.mappers.TodoMapper;
import org.spring.todoservice.models.TaskEntity;
import org.spring.todoservice.models.TodoEntity;
import org.spring.todoservice.repository.TaskRepository;
import org.spring.todoservice.repository.TodoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;
    private final TaskRepository taskRepository;
    private final RestTemplate restTemplate;
    private final EurekaClient eurekaClient;
    private final TodoMapper todoMapper;


    public void createTodo(TodoEntity todoEntity) {
        todoRepository.save(todoEntity);
    }

    public void addTask(TaskEntity taskEntity, String email) {
        TodoEntity todoEntity = todoRepository.findByEmail(email);
        TaskEntity savedTaskEntity = taskRepository.save(taskEntity);
        todoEntity.getTaskEntity().add(savedTaskEntity);
        todoRepository.save(todoEntity);
    }

    public ResponseEntity<String> sendNotification(TaskDTO taskDTO) {

        // Get the instance information of the NotificationService from Eureka
        InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka("NOTIFICATIONSERVICE", false);
        // Build the URL of the NotificationService
        String baseUrl = instanceInfo.getHomePageUrl();

        return restTemplate.
                postForEntity(baseUrl + "/notification", taskDTO, String.class);
    }

    public TodoDTO getTodo(String email) {
        return todoMapper.toDTO(todoRepository.findByEmail(email));
    }


    public List<TodoDTO> getAllTodos() {
        return todoRepository.findAll().stream().map(todoMapper::toDTO).collect(Collectors.toList());
    }

}
