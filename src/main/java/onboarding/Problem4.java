package onboarding;

import java.util.HashMap;

public class Problem4 {

    private static final HashMap<Character, Character> frogMap = new HashMap<>();

    public static String solution(String word) {
        initializeFrogMap();
        return transform(word);
    }

    private static void initializeFrogMap() {
        char upperCaseLetterA = 'A';
        char upperCaseLetterZ = 'Z';
        char lowerCaseLetterA = 'a';
        char lowerCaseLetterZ = 'z';

        for (int i = 0; i < 26; i++) {
            frogMap.put(upperCaseLetterA++, upperCaseLetterZ--);
            frogMap.put(lowerCaseLetterA++, lowerCaseLetterZ--);
        }
    }

    private static String transform(String word) {
        StringBuilder result = new StringBuilder();

        for (char c : word.toCharArray()) {
            // 생성한 FrogMap에 없는 문자인 경우 문자 그대로 결과값에 더한다.
            result.append(frogMap.getOrDefault(c, c));
        }

        return result.toString();
    }
}
