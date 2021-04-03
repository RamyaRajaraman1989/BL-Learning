package com.user.service;

import com.user.entity.User;
import com.user.validation.UserValidationWithLambda;

import java.util.ArrayList;
import java.util.List;

public class UserService {

    public static User addUser(String firstName, String lastName,
                               String emailID, String phone, String password) throws Exception {

        User newUser = UserValidationWithLambda.validateUser(firstName, lastName, emailID, phone, password);
        if (newUser != null) {
            System.out.println("User added");
        }
        return newUser;
    }

    public static void main(String[] args) {
        List<User> userList = new ArrayList();
        try {
            userList.add(UserService.addUser("Ramya", "Rajaraman",
                    "r@gmail.com", "919080770000", "K!ngFisher12"));
        } catch (Exception e) {
            System.out.println("Exception encountered " + e.getMessage());
        }
    }
}
