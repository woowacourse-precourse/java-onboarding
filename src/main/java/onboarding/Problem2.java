package onboarding;

import java.util.List;
import java.util.regex.Pattern;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }

    private static boolean validateCryptogram(String cryptogram) {
        int lengthCryptogram = cryptogram.length();

        // 문자열 길이가 1 이상 ~ 1000 이하인지 확인
        if (lengthCryptogram < 1 || lengthCryptogram > 1000) {
            return false;
        }

        // 문자열이 알파벳 소문자인지 확인
        if (!Pattern.matches("^[a-z]*$", cryptogram)) {
            return false;
        }

        return true;
    }

    private static String[] splitCryptogram(String cryptogram) {
        return cryptogram.split("");
    }
}
