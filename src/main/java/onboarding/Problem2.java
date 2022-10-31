package onboarding;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = cryptogram;

        if (cryptogram.length() < 1 || cryptogram.length() > 1000)
            return "error";
        if (!answer.toLowerCase().equals(cryptogram))
            return "error";

        //중복되는 연속된 2개 문자를 찾기 위한 Regex
        Pattern p = Pattern.compile("(\\w)(\\1+)");
        Matcher duplicateChar = p.matcher(cryptogram);

        while (duplicateChar.find()) {
            answer = answer.substring(0,duplicateChar.start(1)) + answer.substring(duplicateChar.end(2));
            duplicateChar = p.matcher(answer);
        }

        return answer;
    }
}
