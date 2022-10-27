package onboarding;

import java.util.regex.Pattern;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";

        if (checkValidation(cryptogram)) {
            while(checkDuplicateString(cryptogram)) {

            }
            answer = cryptogram;
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
        String pattern = "^[a-z]+$";
        if (!Pattern.matches(pattern, inputString)) {
            return false;
        }

        return true;
    }

    private static boolean checkDuplicateString(String inputString) {
        char previousChar = inputString.charAt(0);
        char nowChar;

        for(int i = 1; i < inputString.length(); i++) {
            nowChar = inputString.charAt(i);
            if (previousChar == nowChar) {
                return true;
            }
            previousChar = nowChar;
        }
        return false;
    }
}
