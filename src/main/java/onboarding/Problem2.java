package onboarding;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 📚 기능 목록
 *
 * 1. 중복 문자의 존재여부를 확인하는 기능
 * 2. 문자 중복을 제거하는 기능
 */
public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = cryptogram;
        answer = removeDuplicate(answer);
        return answer;
    }

    /**
     * 문자의 중복을 제거한다.
     * @param cryptogram 문자열
     * @return 중복이 제거된 문자열
     */
    private static String removeDuplicate(String cryptogram) {

        String result = cryptogram.replaceAll("(\\w)\\1+", "");

        if(checkDuplicate(result)) {
            return removeDuplicate(result);
        }

        return result;
    }

    /**
     * 문자의 중복을 확인한다.
     * @param cryptogram 문자열
     * @return 문자의 중복 여부
     */
    private static boolean checkDuplicate(String cryptogram) {
        Pattern pattern = Pattern.compile("(\\w)\\1+");
        Matcher matcher = pattern.matcher(cryptogram);
        return matcher.find();
    }
}
