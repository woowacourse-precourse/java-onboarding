package onboarding;

import java.util.Stack;

public class Problem2 {
    static String check(String cryptogram) {
        String exception="";
        if(cryptogram.length() < 1 || cryptogram.length() > 1000) {
            exception = "암호문 길이 오류";
        }
        for(char c : cryptogram.toCharArray()) {
            if(!(c >= 97 && c <= 122)) {
                exception = "암호 오류";
            }
        }
        return exception;
    }

    public static String solution(String cryptogram) {
        String answer = "";
        check(cryptogram);
        return answer;
    }
}


