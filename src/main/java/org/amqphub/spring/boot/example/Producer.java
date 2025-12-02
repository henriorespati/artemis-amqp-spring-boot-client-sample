package org.amqphub.spring.boot.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class Producer {

    private static final Logger LOG = LoggerFactory.getLogger(Producer.class);

    @Autowired
    public JmsTemplate jmsTemplate;

    public void sendMessage(String payload) {
        try {
            this.jmsTemplate.convertAndSend("example", payload);
            LOG.info("Message sent successfully");
        } catch (Exception e) {
            LOG.error("Failed to send message: {}", e.getMessage(), e);
        }
    }
}
