package org.spring.notificationservice.controllers;

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
    public ResponseEntity<String> sendNotification() {
        emailNotificationService.sendSimpleMessage("nada.mahmoud200002.nm@gmail.com", "Test", "Test");
        return ResponseEntity.ok("Notification sent");
    }


}
