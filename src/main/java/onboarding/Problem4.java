package onboarding;

import java.util.Locale;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
    }

    public static boolean checkAlpabet(String word) {

        //공백제거
        String onlyAlpabet = word.replaceAll(" ","");

        //알파벳 정규표현식
        String pattern = "^[a-zA-Z]*$";

        return onlyAlpabet.matches(pattern);
    }

    public static String toUpppercase(String word) {
        String result = word.toUpperCase();
        return result;
    }
}
