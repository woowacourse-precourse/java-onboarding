package onboarding;

import java.util.HashMap;

public class Problem4 {

    static int isAlphabet(char alpha) {
        if (alpha >= 65 && alpha <= 90) {   // 영어 대문자
            return 0;
        }
        if (alpha >= 97 && alpha <= 122) {  // 영어 소문자
            return 1;
        }
        return -1;  // 알파벳 아님
    }
    public static String solution(String word) {
        String answer = "";
        return answer;
    }
}
