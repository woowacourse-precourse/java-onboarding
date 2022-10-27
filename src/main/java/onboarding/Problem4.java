package onboarding;

import java.util.HashMap;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        /* 키와 값을 가지는 map 생성 */
        HashMap<Character, Character> m = new HashMap<>();

        /* 청개구리 사전 */
        for (int i = 0; i < 26; i++) {
            /* 대문자 입력 */
            m.put((char) ('A' + i), (char) ('Z' - i));
            /* 소문자 입력 */
            m.put((char) ('a' + i), (char) ('z' - i));
        }

        return answer;
    }
}
