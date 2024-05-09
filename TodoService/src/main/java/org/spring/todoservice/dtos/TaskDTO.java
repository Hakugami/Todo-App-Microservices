package org.spring.todoservice.dtos;

import lombok.Data;
import java.time.LocalDate;
@Data
public class TaskDTO {
    String name;
    LocalDate startDate;
    LocalDate dueDate;
    boolean completed;
}
