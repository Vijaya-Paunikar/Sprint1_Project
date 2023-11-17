package com.example.messaging;

import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;

@MessageEndpoint
public class CloudUserMessageConsumer {

    @ServiceActivator(inputChannel = "inputChannel")
    public void handleMessage(String message) {
        System.out.println("Received Message: " + message);
    }
}