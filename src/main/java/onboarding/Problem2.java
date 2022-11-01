package onboarding;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Problem2 {
    public static String solution(String cryptogram) {
        return checkContinuous(cryptogram);
    }

    private static String checkContinuous(String cryptogram) {
        Pattern pattern = Pattern.compile("(\\w)\\1+");
        Matcher matcher = pattern.matcher(cryptogram);

        while (matcher.find()) {
            cryptogram = matcher.replaceAll("");
            matcher = pattern.matcher(cryptogram);
        }
        return cryptogram;
    }
}
