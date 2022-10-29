package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Problem4 {
    public static String solution(String word) {

        char[] wordCharArray = word.toCharArray();

        List<Character> answer = new ArrayList<>();

        for (char one : wordCharArray) {

            if (!Pattern.matches("^[a-zA-Z]*$", Character.toString(one))) {
                answer.add(one);
                continue;
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
