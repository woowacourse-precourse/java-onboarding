package onboarding;

import java.util.*;

public class Problem4 {
    public static String solution(String word) {
        Map<Character, Character> dictionary = getHashMapFrogDict();
        return getTranslated(word, dictionary);
    }

    public static HashMap<Character, Character> getHashMapFrogDict() {
        HashMap<Character, Character> frogDict = new HashMap<>();
        char froggedChar = 'Z';
        for (char key='A'; key<='Z'; key++) {
            frogDict.put(key, froggedChar);
            froggedChar--;
        }

        froggedChar = 'z';
        for (char key='a'; key<='z'; key++) {
            frogDict.put(key, froggedChar);
            froggedChar--;
        }
        return frogDict;
    }

    public static String getTranslated(String word, Map<Character, Character> dictionary) {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<word.length(); i++) {
            char target = word.charAt(i);
            if (dictionary.containsKey(target)) {
                sb.append(dictionary.get(target));
                continue;
            }
            sb.append(target);
        }
        return sb.toString();
    }
}
