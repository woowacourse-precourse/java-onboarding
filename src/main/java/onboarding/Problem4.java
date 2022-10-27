package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {
    public static String solution(String word) {
        Map<Character, Character> dictionary = getHashMapFrogDict();
        return getTranslatedByDict(dictionary);
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

    public static String getTranslatedByDict(Map<Character, Character> dictionary) {
        String output = "";

        return output;
    }
}
