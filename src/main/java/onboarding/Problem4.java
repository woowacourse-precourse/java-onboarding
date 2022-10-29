package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
    }

    private static Map<String, String> initAlphaMap() {
        // 알파벳 키-값으로 매핑해서 초기화 해주는 메소드
        Map<String, String> map = new HashMap<>();

        // 대문자 매핑
        for (int i = 0; i < 26; i++) {
            int left = 65 + i;
            int right = 90 - i;
            map.put(String.valueOf((char) left), String.valueOf((char) right));
        }

        // 소문자 매핑
        for (int i = 0; i < 26; i++) {
            int left = 97 + i;
            int right = 122 - i;
            map.put(String.valueOf((char) left), String.valueOf((char) right));
        }

        return map;
    }

}
