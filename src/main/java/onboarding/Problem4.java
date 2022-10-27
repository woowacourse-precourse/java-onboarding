package onboarding;

import java.util.HashMap;

public class Problem4 {

    private static final HashMap<Character, Character> frogMap = new HashMap<>();

    public static String solution(String word) {
        initializeFrogMap();
        return "";
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
}
