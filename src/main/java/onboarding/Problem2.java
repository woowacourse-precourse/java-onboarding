package onboarding;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem2 {
    public static String solution(String cryptogram) {
        String pattern = "(([a-z])\\2{1,})";

        Pattern compile = Pattern.compile(pattern);
        Matcher matcher = compile.matcher(cryptogram);

        while (matcher.find()){
            cryptogram=matcher.replaceAll("");
            matcher=compile.matcher(cryptogram);
        }

        return cryptogram;
    }
}
