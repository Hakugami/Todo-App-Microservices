package org.spring.todoservice.repository;

import org.spring.todoservice.models.TaskEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TaskRepository extends MongoRepository<TaskEntity, String> {
    TaskEntity findByName(String name);
}
