package onboarding;

import java.util.List;

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
        // TODO

        return true;
    }

    private static String[] splitCryptogram(String cryptogram) {
        return cryptogram.split("");
    }
}
