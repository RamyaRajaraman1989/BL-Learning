package com.user.validation;
import com.user.entity.User;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidation {

    private static final String EMAIL_PATTERN =
            "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                    + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";

    private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN);


    public static boolean nameValidation(String firstName) throws  Exception{
        if (!(Character.isUpperCase(firstName.charAt(0)) &&
                (firstName.chars().filter(n -> Character.isLetter(n)).count() >= 3)))
             throw new  Exception("First name and Last name is not entered correctly");
        else
            return true;
    }

    public static boolean emailValidation(String email) throws Exception{
        Matcher matcher = pattern.matcher(email);
        if(!matcher.matches()) {
            throw new Exception("Email is not entered correctly");
        }else
            return true;

    }

    public static boolean phoneNoValidation(String phoneNo) throws Exception{

        String[] splitStrings=phoneNo.split(" ");
        if(splitStrings.length==2 && splitStrings[1].length()==10){
            return true;
        }
        else throw new  Exception("PhoneNo is not entered correctly");
    }

    public static boolean passwordValidation(String password) throws Exception{

        if(password.length()<8){
            throw new  Exception("Password length insufficient.Enter min 8 characters.");
        }
        else if (!password.chars()
                .anyMatch(n->Character.isUpperCase(n))){
            throw new Exception("1 Upper case character is mandatory");
        } else if (!password.chars()
                .anyMatch(n->Character.isDigit(n))){
            throw new Exception("Atleast 1 numeric character is mandatory");
        }else if((password.chars().
                filter(n->!(Character.isLetterOrDigit(n)))
                .count())>1){
            throw new Exception("1 Upper case character is mandatory");
        }
        return true;
    }

    public static User validateUser(String firstName, String lastName,
                             String emailID, String phone, String password) throws Exception{
        if (nameValidation(firstName) && nameValidation(lastName) && emailValidation(emailID)
                && phoneNoValidation(phone) && passwordValidation(password)) {
            return (new User(firstName, lastName, emailID, phone, password));
        }
        else
            return null;
    }

}
