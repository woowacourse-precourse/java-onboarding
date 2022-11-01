package onboarding;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem2 {
    public static String solution(String cryptogram) {
        String regex = "(.)\\1+";
        Pattern pattern = Pattern.compile(regex);
        Matcher match = pattern.matcher(cryptogram);

        while(match.find()) {
            cryptogram = cryptogram.replaceAll(regex, "");
            match = pattern.matcher(cryptogram);
        }

        return cryptogram;
    }
}
