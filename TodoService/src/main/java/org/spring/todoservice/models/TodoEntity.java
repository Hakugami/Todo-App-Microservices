package org.spring.todoservice.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Document(collection = "todos")
@Data
public class TodoEntity implements Serializable {
    @Id
    private String id;

    private String title;

    @Indexed(unique = true)
    private String email;

    @DBRef
    private List<TaskEntity> taskEntity = new ArrayList<>();

    @Override
    public String toString() {
        return "TodoEntity{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", taskEntity=" + taskEntity +
                '}';
    }
}
