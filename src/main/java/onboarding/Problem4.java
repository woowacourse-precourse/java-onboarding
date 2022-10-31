package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {
    /**
     * UpperCaseHashMap을 반환해주는 메서드입니다.
     *
     * @return UpperCaseHashMap
     */
    public static Map<Character, Character> getUpperCaseHashMap() {
        Map<Character, Character> map = new HashMap<>();
        char last = 'Z';

        for (int i = 65; i < 91; i++) {
            map.put((char) i, last);
            last--;
        }
        return map;
    }

    /**
     * LowerCaseHashMap을 반환해주는 메서드입니다.
     *
     * @return UpperCaseHashMap
     */
    public static Map<Character, Character> getLowerCaseHashMap() {
        Map<Character, Character> map = new HashMap<>();
        char last = 'z';
        for (int i = 97; i <= 122; i++) {
            map.put((char) i, last);
            last--;
        }
        return map;
    }

    public static String solution(String word) {
        String answer = "";
        return answer;
    }
}
