package onboarding;

import java.util.regex.Pattern;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";

        if (checkValidation(answer)) {

        } else {
            answer = "-1";
        }

        return answer;
    }

    private static boolean checkValidation(String inputString) {
        int inputStringLength = inputString.length();

        // 길이가 1 이상 400 이하여야 한다.
        if (!(1 <= inputStringLength && inputStringLength <= 400)) {
            return false;
        }

        // 알파벳 소문자만 들어 있어야 한다.
        String pattern = "^[a-z]*$";
        if (!Pattern.matches(pattern, inputString)) {
            return false;
        }

        return true;
    }
}
