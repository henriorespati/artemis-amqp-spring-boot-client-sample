package org.amqphub.spring.boot.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.context.event.ApplicationReadyEvent;
// import org.springframework.context.event.EventListener;
import org.springframework.jms.annotation.JmsListener;
// import org.springframework.jms.config.JmsListenerEndpointRegistry;
// import org.springframework.jms.listener.*;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    private static final Logger LOG = LoggerFactory.getLogger(Consumer.class);

    // @Autowired
    // private JmsListenerEndpointRegistry registry;

    @JmsListener(destination = "example") //, id = "jmsListener")
    public void processMsg(String message) {
        LOG.info("============= Received: {}", message);
    }

    // @EventListener(ApplicationReadyEvent.class)
    // public void logJmsListenerConfig() {
    //     LOG.info("------ JMS Listener Configuration ------");

    //     MessageListenerContainer container = registry.getListenerContainer("jmsListener");

    //     if (container == null) {
    //         LOG.warn("No JMS listener container found for ID: jmsListener");
    //         return;
    //     }

    //     if (container instanceof AbstractMessageListenerContainer) {
    //         AbstractMessageListenerContainer mlc = (AbstractMessageListenerContainer) container;
    //         LOG.info("Destination: {}", mlc.getDestination());
    //         LOG.info("Pub/Sub Domain (topic?): {}", mlc.isPubSubDomain());
    //         LOG.info("Message Selector: {}", mlc.getMessageSelector());
    //         LOG.info("Session Transacted: {}", mlc.isSessionTransacted());
    //         LOG.info("Session Acknowledge Mode: {}", mlc.getSessionAcknowledgeMode());
    //         LOG.info("Auto Startup: {}", mlc.isAutoStartup());

    //         if (container instanceof DefaultMessageListenerContainer) {
    //             DefaultMessageListenerContainer dmlc = (DefaultMessageListenerContainer) container;
    //             LOG.info("Concurrent Consumers: {}", dmlc.getConcurrentConsumers());
    //             LOG.info("Max Concurrent Consumers: {}", dmlc.getMaxConcurrentConsumers());
    //         } else {
    //             LOG.info("Concurrency settings are not supported by container type: {}",
    //                     container.getClass().getSimpleName());
    //         }
    //     }

    //     LOG.info("----------------------------------------");
    // }
}
