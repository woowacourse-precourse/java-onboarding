package onboarding;

import java.util.regex.Pattern;

public class Problem4 {
    public static String solution(String word) {
    }

    /** 알파벳인지 확인하는 정규표현식 */
    private static boolean checkStr(String str){
        return Pattern.matches("^[a-zA-Z]*$", str);
    }
}
