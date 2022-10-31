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
        Map<Character, Character> upperCaseAlpha = getUpperCaseHashMap();
        Map<Character, Character> lowerCaseAlpha = getLowerCaseHashMap();

        char[] chars = word.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (Character.isLetter(chars[i])) {
                if (Character.isLowerCase(chars[i])) {
                    chars[i] = lowerCaseAlpha.get(chars[i]);
                } else {
                    chars[i] = upperCaseAlpha.get(chars[i]);
                }
            }
        }
        return new String(chars);
    }
}
