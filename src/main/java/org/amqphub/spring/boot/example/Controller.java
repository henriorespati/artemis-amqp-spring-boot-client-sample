package org.amqphub.spring.boot.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/artemis")
public class Controller {
    
    private static final Logger LOG = LoggerFactory.getLogger(Producer.class);
    private final Producer producer;

    public Controller(Producer producer) {
        this.producer = producer;
    }

    @PostMapping("/send")
    public ResponseEntity<String> send(@RequestBody String message) {
        try {
            producer.sendMessage(message);
            return ResponseEntity.ok("Message sent");
        } catch (Exception e) {
            LOG.error("Failed to send message", e);
            return ResponseEntity.status(500).body("Error sending message");
        }
    }
}
