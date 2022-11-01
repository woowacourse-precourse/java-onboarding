package onboarding;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem2 {
    private static final String REGEX_FIND_DUPLICATION = "([a-z])\\1+";

    public static String solution(String cryptogram) {
        String answer = "answer";
        Pattern pattern = Pattern.compile(REGEX_FIND_DUPLICATION);
        Matcher matcher = pattern.matcher(cryptogram);

        while(matcher.find()) {
            cryptogram = matcher.replaceAll("");
            matcher = pattern.matcher(cryptogram);
        }

        answer = cryptogram;

        return answer;
    }
}
