package com.user.validation;

import com.user.entity.User;
import java.util.function.Predicate;
import java.util.regex.Pattern;

@FunctionalInterface
interface ValidateUserInterface {
    public boolean checkConstraints(String t);
}

public class UserValidationWithLambda {

    public static User validateUser(String firstName, String lastName,
                                    String emailID, String phone, String password) throws Exception {

        if (nameValidation(firstName, lastName) && emailValidation(emailID)
                && phoneNoValidation(phone) && passwordValidation(password)) {
            return (new User(firstName, lastName, emailID, phone, password));
        } else
            return null;
    }

    public static boolean nameValidation(String firstName, String lastName) throws Exception {
        Predicate<String> nameStartWithUpperCase = t -> Character.isUpperCase(t.charAt(0));
        Predicate<String> nameContainsThreeCharsMin = t ->
                t.chars().filter(n -> Character.isLetter(n)).count() >= 3;
        ValidateUserInterface checkName = t ->
                nameStartWithUpperCase.and(nameContainsThreeCharsMin).test(t);

        if (!checkName.checkConstraints(firstName)) {
            throw new Exception("First name is not entered correctly");
        }
        if (!checkName.checkConstraints(lastName)) {
            throw new Exception("Last name is not entered correctly");
        }

        return true;
    }

    public static boolean emailValidation(String email) throws Exception {
        String EMAIL_PATTERN =
                "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                        + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Predicate<String> emailPatternMatch = t -> pattern.matcher(t).matches();
        ValidateUserInterface checkEmail = t -> emailPatternMatch.test(t);
        if (!checkEmail.checkConstraints(email)) {
            throw new Exception("Last name is not entered correctly");
        }

        return true;

    }

    public static boolean phoneNoValidation(String phoneNo) throws Exception {
        Predicate<String[]> phonePredicate = t ->
                (t.length == 2 && t[1].length() == 10);
        ValidateUserInterface checkPhone = t ->
                phonePredicate.test(t.split(" "));

        if (checkPhone.checkConstraints(phoneNo)) {
            throw new Exception("PhoneNo is not entered correctly");
        }
        return true;
    }

    public static boolean passwordValidation(String password) throws Exception {

        if (password.length() < 8) {
            throw new Exception("Password length insufficient.Enter min 8 characters.");
        } else if (!password.chars()
                .anyMatch(n -> Character.isUpperCase(n))) {
            throw new Exception("1 Upper case character is mandatory");
        } else if (!password.chars()
                .anyMatch(n -> Character.isDigit(n))) {
            throw new Exception("Atleast 1 numeric character is mandatory");
        } else if ((password.chars().
                filter(n -> !(Character.isLetterOrDigit(n)))
                .count()) > 1) {
            throw new Exception("1 Upper case character is mandatory");
        }
        return true;
    }

}
