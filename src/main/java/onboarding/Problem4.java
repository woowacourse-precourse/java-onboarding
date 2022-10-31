package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Problem4 {
    public static String solution(String word) {

        try {
            ExceptionProblem4.validateStringLength(word);
        } catch (IllegalArgumentException e){
            return "";
        }

        char[] wordCharArray = word.toCharArray();

        List<Character> answer = new ArrayList<>();

        for (char one : wordCharArray) {

            if (!Pattern.matches("^[a-zA-Z]*$", Character.toString(one))) {
                answer.add(one);
                continue;
            }
            if (Character.isUpperCase(one)) {
                answer.add(convertUppercase(one));
            }
            if (Character.isLowerCase(one)) {
                answer.add(convertLowercase(one));
            }
        }

        String result = answer.stream()
                .map(e -> e.toString())
                .reduce((acc, e) -> acc + e)
                .get();

        return result;
    }

    public static char convertUppercase(char one) {
        int ascii = 155 - (int)one;
        return (char)ascii;
    }

    public static char convertLowercase(char one) {
        int ascii = 219 - (int)one;
        return (char)ascii;
    }
}

class ExceptionProblem4 {
    public static void validateWord(String word) {
        enterWord(word);
        validateStringLength(word);
    }

    public static void enterWord(String word) {
        if (word.equals("")) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateStringLength(String word) {
        if (word.length() < 1 || word.length() > 1000) {
            throw new IllegalArgumentException();
        }
    }
}