package org.amqphub.spring.boot.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class ArtemisAmqpApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArtemisAmqpApplication.class, args);
    }
}
