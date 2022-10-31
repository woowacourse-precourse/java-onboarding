package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {

    private static Map<Character, Character> treeFrogs;

    public static String solution(String word) {
        treeFrogs = new HashMap<>();
        createTreeFrogs();
        return changeWordWithTreeFrogs(word);
    }

    private static String changeWordWithTreeFrogs(String word) {
        StringBuilder changeWord = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char current = word.charAt(i);
            if (treeFrogs.get(current) == null) {
                changeWord.append(current);
                continue;
            }
            changeWord.append(treeFrogs.get(word.charAt(i)));
        }
        return changeWord.toString();
    }

    private static void createTreeFrogs() {
        char start = 'a';
        char end = 'z';
        mappingAlphabetToMap(start, end);

        start = 'A';
        end = 'Z';
        mappingAlphabetToMap(start, end);
    }

    private static void mappingAlphabetToMap(char start, char end) {
        int idx = 0;
        for (int ascii = start; ascii <= end; ascii++) {
            char origin = (char) ascii;
            char change = (char) (end - idx++);
            treeFrogs.put(origin, change);
        }
    }

}
