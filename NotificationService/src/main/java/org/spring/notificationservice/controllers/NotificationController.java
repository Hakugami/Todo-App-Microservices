package org.spring.notificationservice.controllers;

import org.spring.notificationservice.dto.TaskDTO;
import org.spring.notificationservice.services.EmailNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController {

    private final EmailNotificationService emailNotificationService;

    @Autowired
    public NotificationController(EmailNotificationService emailNotificationService) {
        this.emailNotificationService = emailNotificationService;
    }

    @PostMapping("/notification")
    public ResponseEntity<String> sendCompletionNotification(TaskDTO taskDTO) {
        if (emailNotificationService.sendSimpleMessage(taskDTO))
            return ResponseEntity.ok("Notification sent");
        else
            return ResponseEntity.badRequest().body("Notification failed, ensure that the email is valid");
    }



}
