package com.example.messaging;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.handler.annotation.Payload;

@Configuration
@EnableIntegration
public class CloudVendorMessagingConfig {

    @Bean
    public MessageChannel inputChannel() {
        return new DirectChannel();
    }

    @Bean
    public MessageChannel outputChannel() {
        return new DirectChannel();
    }

    @MessagingGateway
    public interface CloudVendorGateway {
        @Gateway(requestChannel = "inputChannel")
        void sendRequestToCloudUser(@Payload String message);
    }

    @ServiceActivator(inputChannel = "inputChannel")
    public void handleIncomingMessage(Message<String> message) {
        String payload = message.getPayload();
        System.out.println("Received message: " + payload);
        // Process the message as needed
    }
}
