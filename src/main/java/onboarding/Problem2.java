package onboarding;

import onboarding.problem2.NotMatchingCryptogramLength;
import org.junit.platform.commons.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";

        // 예외사항
        // 1-1 cryptogram 길이 체크
        if(isNotMatchingCryptogramLength(cryptogram)){
            throw new NotMatchingCryptogramLength("cryptogram 길이가 맞지 않습니다.");
        }


        return answer;
    }

    private static boolean isNotMatchingCryptogramLength(String cryptogram) {
        return cryptogram.length() < 1 || cryptogram.length() > 1000;
    }

}
