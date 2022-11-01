package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            int c = word.charAt(i);
            // 대문자
            if (c >= 65 && c <= 90) {
                c = 155 - c;
                // 소문자
            } else if (c >= 97 && c <= 122) {
                c = 219 - c;
            }
            // 스페이스의 경우는 그냥 넣음
            sb.append((char) c);
        }


        return sb.toString();
    }
}
