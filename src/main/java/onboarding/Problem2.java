package onboarding;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem2 {
    private static final String SUCCESSIVE_REGEX = "a{2,}|b{2,}|c{2,}|d{2,}|e{2,}|f{2,}|g{2,}|h{2,}|i{2,}|" +
            "j{2,}|k{2,}|l{2,}|m{2,}|n{2,}|o{2,}|p{2,}|q{2,}|r{2,}|s{2,}|t{2,}|u{2,}|v{2,}|w{2,}|x{2,}|y{2,}|z{2,}";
    private static final Pattern SUCCESSIVE_PATTERN = Pattern.compile(SUCCESSIVE_REGEX);
    private static final String BLANK = "";

    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }

    public static String eraseSuccessiveCharacters(String str) {
        Matcher successiveStringMatcher = SUCCESSIVE_PATTERN.matcher(str);
        return successiveStringMatcher.replaceAll(BLANK);
    }

    public static String eraseSuccessiveCharactersUntilUnchanged(String str) {
        String ret;
        while (!(ret = eraseSuccessiveCharacters(str)).equals(str)) {
            str = eraseSuccessiveCharacters(str);
        }

        return ret;
    }
}
