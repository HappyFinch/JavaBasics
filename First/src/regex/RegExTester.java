package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExTester {
    public static void main(String[] args){
        String emailRegex = "^(.+)@(.+).(.+)$"; // regex for email
        Pattern pattern = Pattern.compile(emailRegex);  // compile regex
        String email = "jeff@gmail.com";
        Matcher matcher = pattern.matcher(email); // match email to regex
        System.out.println(matcher.matches()); // true;   
    }
  }
