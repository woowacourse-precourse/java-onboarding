package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {
    private static final int ALPHABETS_COUNT = 26;

    public static String solution(String word) {
        Map<Character, Character> frogMap = generateFrogMap();
        return transform(frogMap, word);
    }

    private static Map<Character, Character> generateFrogMap() {
        HashMap<Character, Character> frogMap = new HashMap<>();

        char upperCaseLetterA = 'A';
        char upperCaseLetterZ = 'Z';
        char lowerCaseLetterA = 'a';
        char lowerCaseLetterZ = 'z';

        for (int i = 0; i < ALPHABETS_COUNT; i++) {
            frogMap.put(upperCaseLetterA++, upperCaseLetterZ--);
            frogMap.put(lowerCaseLetterA++, lowerCaseLetterZ--);
        }

        return frogMap;
    }

    private static String transform(Map<Character, Character> frogMap, String word) {
        StringBuilder result = new StringBuilder();

        for (char c : word.toCharArray()) {
            // 생성한 FrogMap에 없는 문자인 경우 문자 그대로 결과값에 더한다.
            result.append(frogMap.getOrDefault(c, c));
        }

        return result.toString();
    }
}
