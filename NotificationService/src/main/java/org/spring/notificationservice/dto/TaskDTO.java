package org.spring.notificationservice.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class TaskDTO implements Serializable {
    String name;
    LocalDate startDate;
    LocalDate dueDate;
    boolean completed;
    String email;
}