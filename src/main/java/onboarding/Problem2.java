package onboarding;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";

        if (cryptogram.length() < 1 || cryptogram.length() > 1000)
            return "invalid cryptogram";

        Pattern p = Pattern.compile("^.*(.)\\1.*$");
        Matcher m = p.matcher(cryptogram);

        return answer;
    }
}
