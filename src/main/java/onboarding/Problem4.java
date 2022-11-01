package onboarding;

import java.util.Locale;

public class Problem4 {

    private static char getKey(char c) {
        String keys = "zyxwvutsrqponmlkjihgfedcba";

        if (Character.isUpperCase(c)) {
            return (keys.toUpperCase().charAt(c - 'A'));
        }
        return (keys.charAt(c - 'a'));
    }

    private static String encrypt(String word) {
        String result = "";

        for (char w : word.toCharArray()) {
            if (Character.isAlphabetic(w)) {
                result += getKey(w);
            }
            else {
                result += w;
            }
        }
        return (result);
    }

    public static String solution(String word) {
        String answer = encrypt(word);
        return answer;
    }
}
