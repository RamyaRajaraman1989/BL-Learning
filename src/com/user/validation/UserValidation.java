package com.user.validation;

import com.user.entity.User;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidation {

    private final String EMAIL_PATTERN =
            "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                    + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";

    private final Pattern pattern = Pattern.compile(EMAIL_PATTERN);

    User newuser = new User();

    public boolean nameValidation(String firstName) {

        if (Character.isUpperCase(firstName.charAt(0)) &&

                (firstName.chars().filter(n -> Character.isLetter(n)).count() >= 3)
        )

            return true;

        else
            return false;
    }


    public boolean emailValidation(String email) {

        Matcher matcher = pattern.matcher(email);

        return matcher.matches();

    }

    public boolean phoneNoValidation(String phoneNo) {

        return true;
    }

    public boolean passwordValidation(String password) {

        return true;
    }

    public User validateUser(String firstName, String lastName,
                             String emailID, String phone, String password) {
        if (nameValidation(firstName) && nameValidation(lastName) && emailValidation(emailID)
                && phoneNoValidation(phone) && passwordValidation(password)) {
            return (new User(firstName, lastName, emailID, phone, password));
        } else
            return null;
    }


}
