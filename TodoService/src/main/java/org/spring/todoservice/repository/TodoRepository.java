package org.spring.todoservice.repository;

import org.spring.todoservice.models.TodoEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TodoRepository extends MongoRepository<TodoEntity, String> {

}
