package onboarding;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Problem2 {
    private static final Pattern pattern = Pattern.compile("([a-z])\\1");

    private static String decrypt(String cryptogram) {
        Matcher matcher = pattern.matcher(cryptogram);
        while (matcher.find()) {
            matcher.reset(matcher.replaceAll(""));
        }
        return matcher.replaceAll("");
    }

    public static String solution(String cryptogram) {
        return decrypt(cryptogram);
    }
}
