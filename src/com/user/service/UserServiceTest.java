package com.user.service;

import com.user.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    @Test
    public void addUserTest() {
        try {
            User testUser = UserService.addUser("Ramya", "Rajaraman",
                    "r@gmail.com", "91 9080770000", "K!ngFisher12");
            Assertions.assertEquals(testUser.getLastName(), "Rajaraman");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void nameTest() {
        try {
            //Exception testing
            assertThrows(Exception.class, () -> UserService.addUser("Ramya", "rajaraman",
                    "r@gmail.com", "91 9080770000", "K!ngFisher12"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void phoneTest() {
        try {
            //Exception thrown
            assertThrows(Exception.class, () -> UserService.addUser("Ramya", "Rajaraman",
                    "r@gmail.com", "919080770000", "K!ngFisher12"));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}