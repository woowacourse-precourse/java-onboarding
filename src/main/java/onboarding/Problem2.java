package onboarding;

import java.util.regex.*;

public class Problem2 {
    public static String solution(String cryptogram) {
        Pattern pattern = Pattern.compile("(\\w)\\1+");

        while (pattern.matcher(cryptogram).find()) {
            cryptogram = cryptogram.replaceAll("(\\w)\\1+","");
        }

        return cryptogram;
    }
}