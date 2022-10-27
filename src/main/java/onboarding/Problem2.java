package onboarding;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem2 {
    public static String solution(String cryptogram) {
        return decoder(cryptogram);
    }

    private static String decoder(String cryptogram) {
        String result = "";

        if (cryptogram.length() < 1 || cryptogram.length() > 1000 || !cryptogram.matches("^[a-z]*$"))
            return cryptogram;

        result += cryptogram.charAt(0);
        for (int i = 0; i < cryptogram.length() - 1; i++) {
            if (cryptogram.charAt(i) != cryptogram.charAt(i+1))
                if (i > 0 && cryptogram.charAt(i) != cryptogram.charAt(i-1))
                    result += cryptogram.charAt(i);
        }
        result += cryptogram.charAt(cryptogram.length() - 1);

        if (result.matches("^[a-z]*([a-z])\\1[a-z]*$")) {
            return decoder(result);
        }

        return result;
    }
}
