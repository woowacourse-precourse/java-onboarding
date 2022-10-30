package onboarding;

import java.util.regex.Pattern;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";

        Pattern pattern = Pattern.compile("([a-z])\\1+");

        cryptogram = pattern.matcher(cryptogram).replaceAll("");

        answer = cryptogram;

        return answer;
    }
}
