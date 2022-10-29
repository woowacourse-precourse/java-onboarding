package onboarding;

/** 구현 기능 목록
 * 1. 청개구리 사전에 따라 하나의 문자를 변환
 * 2. 청개구리 사전에 따라 문자열을 변환
 * */

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
    }

    private static Character changeLetter(Character letter) {
        int ascii = letter;
        if (ascii >= 65 && ascii <= 90) {
            ascii += (78-ascii)*2-1;
        }
        if (ascii >= 97 && ascii <= 122) {
            ascii += (110-ascii)*2-1;
        }
        return (char)ascii;
    }
}
