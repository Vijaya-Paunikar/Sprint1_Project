package com.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.example.model.CloudUser;

class CloudUserTests {

    @Test
    void testGetName() {
        CloudUser cloudUser = new CloudUser();
        cloudUser.setName("John Doe");

        assertEquals("John Doe", cloudUser.getName());
    }

    @Test
    void testSetName() {
        CloudUser cloudUser = new CloudUser();
        cloudUser.setName("Jane Doe");

        assertEquals("Jane Doe", cloudUser.getName());
    }

    @Test
    void testGetPhoneNumber() 
    {
        CloudUser cloudUser = new CloudUser();
        cloudUser.setPhoneNumber(1234567890);

        assertEquals(1234567890, cloudUser.getPhoneNumber());
    }

    @Test
    void testSetPhoneNumber() {
        CloudUser cloudUser = new CloudUser();
        cloudUser.setPhoneNumber(9876543217L); // Use the correct literal with the L suffix

        assertEquals(9876543217L, cloudUser.getPhoneNumber());
    }
    
    @Test
    void testUserStatus() {
        CloudUser cloudUser = new CloudUser();
        cloudUser.setUserStatus("active");

        assertEquals("active", cloudUser.getUserStatus());
    }
    
    @Test
    void testDefaultConstructor() {
        CloudUser cloudUser = new CloudUser();
        assertNull(cloudUser.getName());
        assertEquals(0, cloudUser.getPhoneNumber());
        assertNull(cloudUser.getUserStatus());
    }

}
