package onboarding;

import java.util.HashMap;

public class Problem4 {
    public static HashMap<Character, Character> getMap() {
        HashMap<Character, Character> map = new HashMap<>();

        char j = 'Z';

        for (char i = 'A'; i <= 'Z'; i++) {
            map.put(i, j);
            j--;
        }

        j = 'z';

        for (char i = 'a'; i <= 'z'; i++) {
            map.put(i, j);
            j--;
        }

        return map;
    }

    public static boolean isAlphabet(char c) {
        if (('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z')) {
            return true;
        } else {
            return false;
        }
    }

    public static String convert(String word, HashMap<Character, Character> map) {
        StringBuilder newWord = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            char character = word.charAt(i);

            if (isAlphabet(character)) {
                newWord.append(map.get(character));
            } else {
                newWord.append(character);
            }
        }

        return newWord.toString();
    }

    public static String solution(String word) {
        return convert(word, getMap());
    }
}
