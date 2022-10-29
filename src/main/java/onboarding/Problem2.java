package onboarding;

import onboarding.problem2.NotMatchingCryptogramLengthOrLowerCase;
import org.junit.platform.commons.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";

        // 예외사항
        // 1-1,2 cryptogram 길이와 소문자 체크
        if(isNotCryptogramLengthOrLowerCase(cryptogram)){
            throw new NotMatchingCryptogramLengthOrLowerCase("cryptogram 길이 및 소문자가 아닙니다.");
        }

        return answer;
    }

    // 예외사항 1-1,2 cryptogram 길이와 소문자 체크
    public static boolean isNotCryptogramLengthOrLowerCase(String cryptogram){
        boolean found = true;

        if(StringUtils.isBlank(cryptogram)){
            found = true;
        }

        String regex = "^[a-z]{1,1000}$";
        Pattern p = Pattern.compile(regex);
        Matcher matcher = p.matcher(cryptogram);
        if(matcher.matches()){
            found = false;
        }
        return found;
    }

}
