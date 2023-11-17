package com.example.messaging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cloudvendor")
public class CloudVendorController {

    @Autowired
    private CloudVendorMessagingConfig.CloudVendorGateway cloudVendorGateway;

    @GetMapping("/sendRequest/{message}")
    public String sendRequestToCloudUser(@PathVariable String message) {
        cloudVendorGateway.sendRequestToCloudUser(message);
        return "Successfully sent message to CloudUser: " + message;
    }
}