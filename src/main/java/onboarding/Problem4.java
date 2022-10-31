package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {

    private static Map<Character, Character> convertMap = new HashMap<>();

    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();

        char[] frogWords = {'Z', 'Y', 'X', 'W', 'V', 'U', 'T', 'S',
                'R', 'Q', 'P', 'O', 'N', 'M', 'L', 'K', 'J', 'I', 'H',
                'G', 'F', 'E', 'D', 'C', 'B', 'A'};

        convertMap = makeMap(frogWords);

        return answer.toString();
    }

    private static Map<Character, Character> makeMap(char[] words) {
        Map<Character, Character> convertMap = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            convertMap.put(words[words.length - 1 - i], words[i]);
        }
        return convertMap;
    }

    private static boolean isUpper(char oneWord) {
        return Character.isUpperCase(oneWord);
    }

    private static boolean isLower(char oneWord) {
        return Character.isLowerCase(oneWord);
    }

    private static boolean isSpace(char oneWord) {
        if (oneWord == ' ') {
            return true;
        }
        return false;
    }

}