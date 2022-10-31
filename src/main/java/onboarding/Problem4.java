package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {
    private static final int SUM_KEY_VALUE = 155;

    public static String solution(String word) {
        StringBuilder sb = new StringBuilder();

        for (char key : word.toCharArray()) {
            addValueToOutput(key, sb);
        }
        return sb.toString();
    }

    private static Map<Character, Character> createReverseDict() {
        Map<Character, Character> reverseDict = new HashMap<>();
        char base = 'A';
        while (Character.isAlphabetic(base)) {
            reverseDict.put(base, getReverseValue(base++));
        }
        return reverseDict;
    }

    private static char getOriginCaseValue(Map<Character, Character> dictionary, char key) {
        char value = getDictValue(dictionary, key);
        return Character.isLowerCase(key) ? Character.toLowerCase(value) : value;
    }

    private static void addValueToOutput(char key, StringBuilder sb) {
        char getValue = !Character.isAlphabetic(key) ? key : getOriginCaseValue(createReverseDict(), key);
        sb.append(getValue);
    }

    private static char getReverseValue(char base) {
        return (char) (SUM_KEY_VALUE - (int) base);
    }

    private static char getDictValue(Map<Character, Character> dictionary, char key) {
        return dictionary.get(Character.toUpperCase(key));
    }
}
