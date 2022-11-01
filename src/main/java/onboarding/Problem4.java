package onboarding;

import java.util.HashMap;

public class Problem4 {
    static final HashMap<Character, Character> dict = new HashMap<>();
    public static String solution(String word) {
        String answer = "";
        initDict();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if (!Character.isAlphabetic(c)) {
                stringBuilder.append(c);
                continue;
            }

            stringBuilder.append(dict.get(c));
        }

        answer = stringBuilder.toString();
        return answer;
    }

    private static void initDict() {
        for (int i = 0; i < 26; i++) {
            dict.put((char) ('A' + i), (char) ('Z' - i));
        }

        for (int i = 0; i < 26; i++) {
            dict.put((char) ('a' + i), (char) ('z' - i));
        }
    }
}
