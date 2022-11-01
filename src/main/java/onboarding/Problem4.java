package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        /* 아스키코드 이용 */
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            map.put((char) ('A' + i), (char) ('Z' - i));    // 대문자 역순 저장, A ~ Z 65 ~ 90
            map.put((char) ('a' + i), (char) ('z' - i));    // 소문자 역순 저장, a ~ z 97 ~ 122
        }

        for (int i = 0; i < word.length(); i++) {
            Character character = word.charAt(i);
            answer += map.getOrDefault(character, character);   // Map 검색 후 해당 문자 출력
        }
        return answer;
    }
}
