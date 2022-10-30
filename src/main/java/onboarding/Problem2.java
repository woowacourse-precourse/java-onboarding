package onboarding;

import java.util.regex.Pattern;

public class Problem2 {
    public static String solution(String cryptogram) {
        if(isException(cryptogram)) throw new RuntimeException("잘못된 인자입니다.");
        String answer = "answer";
        return answer;
    }

    private static Boolean isException(String str) {
        if(str.length() < 1 || str.length() > 1000) return true;
        return !Pattern.matches("[a-z]*", str);
    }
}
