package org.spring.notificationservice.services;


import lombok.extern.slf4j.Slf4j;
import org.spring.notificationservice.dto.TaskDTO;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EmailNotificationService {

    private final JavaMailSender emailSender;

    public EmailNotificationService(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }



    public boolean sendSimpleMessage(TaskDTO taskDTO) {

       try {
           SimpleMailMessage message = buildMessageFromTask(taskDTO);
           emailSender.send(message);
       }
       catch(Exception exception) {
           log.error("Error while sending email: ", exception);
           return false;
       }
         return true;
    }


    public SimpleMailMessage buildMessageFromTask(TaskDTO taskDTO) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("{spring.mail.username}");
        message.setTo(taskDTO.getEmail());
        if(taskDTO.isCompleted()){
            message.setSubject("Task Completed: " + taskDTO.getName());
            message.setText("Task " + taskDTO.getName() + " has been completed.");
        }
        else{
            message.setSubject("Task Reminder: " + taskDTO.getName());
            message.setText("Task " + taskDTO.getName() + " is due on " + taskDTO.getDueDate());
        }
        return message;
    }

}