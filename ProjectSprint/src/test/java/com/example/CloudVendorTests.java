package com.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.example.model.CloudVendor;

class CloudVendorTests {

    @Test
    void testGetDescription() {
        CloudVendor cloudVendor = new CloudVendor();
        cloudVendor.setDescription("Cloud services provider");

        assertEquals("Cloud services provider", cloudVendor.getDescription());
    }

    @Test
    void testSetDescription() {
        CloudVendor cloudVendor = new CloudVendor();
        cloudVendor.setDescription("Leading cloud provider");

        assertEquals("Leading cloud provider", cloudVendor.getDescription());
    }

    @Test
    void testGetStatus() {
        CloudVendor cloudVendor = new CloudVendor();
        cloudVendor.setStatus("active");

        assertEquals("active", cloudVendor.getStatus());
    }

    @Test
    void testSetStatus() {
        CloudVendor cloudVendor = new CloudVendor();
        cloudVendor.setStatus("inactive");

        assertEquals("inactive", cloudVendor.getStatus());
    }

    @Test
    void testId() {
        CloudVendor cloudVendor = new CloudVendor();
        cloudVendor.setId(1L);

        assertEquals(1L, cloudVendor.getId());
    }

}