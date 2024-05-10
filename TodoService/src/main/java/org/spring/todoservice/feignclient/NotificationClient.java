package org.spring.todoservice.feignclient;

import org.spring.todoservice.dtos.TaskDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "NOTIFICATIONSERVICE")
public interface NotificationClient {
    @PostMapping("/notification")
    ResponseEntity<String> sendNotification(@RequestBody TaskDTO taskDTO);


}