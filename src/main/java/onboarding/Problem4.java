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

        StringBuilder sb = new StringBuilder();

        /* 문자열 바꾸는 기능 */
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if (c == ' ') sb.append(' ');
            else sb.append(m.get(c));
        }

        answer = sb.toString();

        return answer;
    }
}
