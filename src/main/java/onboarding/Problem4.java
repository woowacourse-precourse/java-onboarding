package onboarding;

import java.util.HashMap;

public class Problem4 {

    static char[] wordToCharArray(String word) {
        char[] wordChar = word.toCharArray();

        return wordChar;
    }

    static int isAlphabet(char alpha) {
        if (alpha >= 65 && alpha <= 90) {   // 영어 대문자
            return 0;
        }
        if (alpha >= 97 && alpha <= 122) {  // 영어 소문자
            return 1;
        }
        return -1;  // 알파벳 아님
    }

    static int findIdxASCII(char alpha) {
        int idx = Integer.MAX_VALUE;

        if (isAlphabet(alpha) == 0) {
            idx = alpha - 'A';
        }
        if (isAlphabet(alpha) == 1) {
            idx = alpha - 'a';
        }

        return  idx;
    }

    public static String solution(String word) {
        String answer = "";
        return answer;
    }
}
