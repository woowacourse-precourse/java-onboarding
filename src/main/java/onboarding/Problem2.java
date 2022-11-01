package onboarding;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem2 {
    static Pattern pattern = Pattern.compile("(\\w)\\1+");
    static Matcher matcher;

    public static String solution(String cryptogram) {
        return removeDuplicate(cryptogram);
    }

    /*
    * 정규식을 사용해 중복을 제거하고 남은 문자열을 반환
    *
    * @return String
    * */
    private static String removeDuplicate(String cryptogram) {
        matcher = pattern.matcher(cryptogram);

        while (matcher.find()) {
            String[] splitStrings = cryptogram.split(matcher.group());
            if (splitStrings.length <= 1) {
                return "";
            }
            cryptogram = splitStrings[0] + removeDuplicate(splitStrings[1]);
            matcher = pattern.matcher(cryptogram);
        }

        return cryptogram;
    }
}
