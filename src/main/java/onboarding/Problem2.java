package onboarding;

import java.util.regex.Pattern;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";

        Pattern pattern = Pattern.compile("([a-z])\\1+");

        boolean removeCheck = true;

        while (removeCheck) {

            int beforeRemove = cryptogram.length();
            cryptogram = pattern.matcher(cryptogram).replaceAll("");
            int afterRemove = cryptogram.length();

            if (beforeRemove == afterRemove) {
                removeCheck = false;
            }

        }

        answer = cryptogram;

        return answer;
    }
}
