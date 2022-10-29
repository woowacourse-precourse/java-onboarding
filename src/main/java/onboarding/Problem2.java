package onboarding;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 📚 기능 목록
 *
 * 1. 중복문자의 유무를 확인하는 기능
 * 2. 중복문자를 제거하는 기능
 */
public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = cryptogram;
        answer = removeDuplicate(answer);
        return answer;
    }

    /**
     * 중복문자가 제거된 문자열을 반환한다.
     * @param cryptogram 문자열
     */
    private static String removeDuplicate(String cryptogram) {

        String result = cryptogram.replaceAll("(\\w)\\1+", "");

        if(checkDuplicate(result)) {
            return removeDuplicate(result);
        }

        return result;
    }

    /**
     * 문자열에 연속된 중복문자가 있으면 true
     * @param cryptogram 문자열
     */
    private static boolean checkDuplicate(String cryptogram) {
        Pattern pattern = Pattern.compile("(\\w)\\1+");
        Matcher matcher = pattern.matcher(cryptogram);
        return matcher.find();
    }
}
