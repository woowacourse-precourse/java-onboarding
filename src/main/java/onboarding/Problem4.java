package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
    }

    private static Map initAlphaMap() {
        // 알파벳 키-값으로 매핑해서 초기화 해주는 메소드
        Map<Character, Character> map = new HashMap<>();

        // 대문자 매핑
        for (int i = 0; i < 26; i++) {
            int left = 65 + i;
            int right = 90 - i;
            map.put((char) left, (char) right);
        }

        // 소문자 매핑
        for (int i = 0; i < 26; i++) {
            int left = 97 + i;
            int right = 122 - i;
            map.put((char) left, (char) right);
        }

        return map;
    }

}
