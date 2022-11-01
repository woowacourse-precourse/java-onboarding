package onboarding;

import java.util.HashMap;

public class Problem4 {
    private static HashMap<Character, Character> map = new HashMap<>();
    public static String solution(String word) {
        makeDictionary();
        return convert(word);
    }

    private static void makeDictionary() {
        int diff = 25;
        for (int i = 'A'; i <= 'Z'; i++) {
            map.put((char) i, (char) (i + diff));
            diff -= 2;
        }
    }

    private static String convert(String word) {
        StringBuilder sb = new StringBuilder(word.length());

        for (char c : word.toCharArray()) {
            if (!isAlphabetic(c)) {
                sb.append(c);
            }
            if (isUpperCase(c)) {
                sb.append(map.get(c));
            }
            if (isLowerCase(c)) {
                sb.append(Character.toLowerCase(map.get(Character.toUpperCase(c))));
            }
        }
        return sb.toString();
    }

    private static boolean isAlphabetic(char c) {
        return Character.isAlphabetic(c);
    }

    private static boolean isUpperCase(char c) {
        return Character.isUpperCase(c);
    }

    private static boolean isLowerCase(char c) {
        return Character.isLowerCase(c);
    }
}
