package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }

    /**
     * 기능 목록 1번: 인자의 유효성 검사 메서드
     * */
    private static void check(String cryptogram) {
        if(cryptogram.length() < 1 || cryptogram.length() > 1000)
            throw new IllegalArgumentException("인자의 길이를 확인해주십시오.");
        for (char c : cryptogram.toCharArray()) {
            if(c==' ') throw new IllegalArgumentException("연속된 문자여야 합니다.");
            if (c < 'a' || c > 'z')
                throw new IllegalArgumentException("소문자 알파벳이 아닌 문자가 포함되어있습니다.");
        }
    }

}
