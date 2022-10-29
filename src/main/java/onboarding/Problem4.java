package onboarding;

import java.util.HashMap;

public class Problem4 {
    public static final String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String lowerCase = "abcdefghijklmnopqrstuvwxyz";

    public static String solution(String word) {

        HashMap<Character, Character> frogMap = new HashMap<>();

        frogMap = frogMapper(frogMap, upperCase);
        frogMap = frogMapper(frogMap, lowerCase);

        String answer = getWordTranslation(word, frogMap);

        return answer;
    }

    public static HashMap<Character, Character> frogMapper(HashMap<Character, Character> hashmap, String string) {
        for (int i = 0; i < string.length() - 1; i += 1) {
            hashmap.put(string.charAt(i), string.charAt(string.length() - 1 - i));
        }
        return hashmap;
    }

    public static String getWordTranslation(String word, HashMap<Character, Character> frogMap) {
        String string = "";
        for (char c : word.toCharArray()) {
            string += getHashMapValue(c, frogMap);
        }
        return string;
    }

    public static String getHashMapValue(Character c, HashMap<Character, Character> hashMap) {
        if (isSpacing(c)) {
            return " ";
        }
        return hashMap.get(c).toString();
    }

    public static boolean isSpacing(char c) {
        return c == ' ';
    }
}
