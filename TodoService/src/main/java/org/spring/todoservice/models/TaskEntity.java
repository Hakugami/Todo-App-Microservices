package org.spring.todoservice.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.io.Serializable;
import java.time.LocalDate;

@Document(collection = "tasks")
@Data
public class TaskEntity implements Serializable {
    @MongoId
    String name;
    LocalDate startDate;
    LocalDate dueDate;
    boolean completed;
}
