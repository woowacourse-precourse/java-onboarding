package onboarding;

import java.util.Arrays;
import java.util.Locale;

public class Problem4 {
    /**
     * 일반 알파벳 배열
     */
    static char[] alpabet = new char[26];
    /**
     * 청개구리(역순 알파벳 배열)
     */
    static char[] reAlpabet = new char[26];
    public static String solution(String word) {
        StringBuilder sb = new StringBuilder();

        // 청개구리 배열과, 일반 알파벳 배열을 생성한다.
        for (int i = 0; i < 26; i++) {
            alpabet[i] = (char) ('A' + i);
            reAlpabet[i] =  (char) ('Z'- i);
        }
        
        // 입력된 문자열을 조건에 따라 뒤집음
        for (char c: word.toCharArray()) {
            if(c != ' ') sb.append(reverseCharcter(c));
            else sb.append(" "); // 띄어 쓰기는 그대로 사용
        }

        return sb.toString();
    }

    /**
     * 대소문자를 판별하는 함수
     * @param c
     * @return {boolean} true = 소문자 : false : 대문자
     */
    public static boolean isLowerCase(char c) {
        // 1. 소문자인 경우
        if(c >= 97 && c <= 122) return true;
        // 2. 대문자인 경우
        else return false;
    }

    /**
     * 입력된 문자를 청개구리 사전에 맞게 변환하는 함수
     * @param c
     * @return {String}
     */
    public static String reverseCharcter(char c) {
        int alpaIndex = 0;

        if(isLowerCase(c)) {
            // 소문자인 경우
            alpaIndex = (int) (c - 97);
            return String.valueOf(reAlpabet[alpaIndex]).toLowerCase();
        } else {
            // 대문자인 경우
            alpaIndex = (int) (c - 65);
            return String.valueOf(reAlpabet[alpaIndex]);
        }
    }
}
