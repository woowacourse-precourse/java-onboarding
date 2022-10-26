package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {

    private static final Map<Character, Character> treeFrogMap = new HashMap<>();

    public static String solution(String word) {
        createTreeFrogMap();
        return changeWordWithTreeFrogMap(word);
    }

    private static String changeWordWithTreeFrogMap(String word) {
        StringBuilder changeWord = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char current = word.charAt(i);
            if (current == ' ') {
                changeWord.append(current);
                continue;
            }
            changeWord.append(treeFrogMap.get(word.charAt(i)));
        }
        return changeWord.toString();
    }

    private static void createTreeFrogMap() {
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
            char originValue = (char) ascii;
            char changeValue = (char) (end - idx++);
            treeFrogMap.put(originValue, changeValue);
        }
    }

}
