package onboarding;

import java.util.HashMap;

public class Problem4 {
    private static HashMap<Character, Character> map = new HashMap<>();
    public static String solution(String word) {
        String answer = "";
        return answer;
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
        }
        return sb.toString();
    }

    private static boolean isAlphabetic(char c) {
        return Character.isAlphabetic(c);
    }

    private static boolean isUpperCase(char c) {
        return Character.isUpperCase(c);
    }
}
