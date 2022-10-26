package onboarding;

import java.util.regex.Pattern;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }

    public boolean validationCheck(String cryptogram) {
        if (cryptogram.length() > 1000 || cryptogram.length() < 1) {
            return false;
        } else if (!Pattern.matches("[a-z]*$", cryptogram)) { // 정규식 패턴 매칭
            return false;
        }
        return true;
    }
    public boolean needToCompress(String cryptogram) {
        for (int i = 0; i < cryptogram.length() - 1; i++) {
            if (cryptogram.charAt(i) == cryptogram.charAt(i+1)) {
                return true;
            }
        }
        return false;
    }
}


/*
입력 조건에 맞지 않는 경우 예외처리 기능
길이가 1 이상 1000 이하인지 체크
알파벳 소문자로만 이루어져 있는지 체크
문자열을 압축하는 기능
더 이상 압축할 문자열이 있는지 체크하는 기능
 */