package onboarding;

import java.util.HashMap;

public class Problem4 {

    static char maxLetter = 'a' + 'z';

    public static String solution(String word) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            if (!Character.isLetter(letter)) {
                sb.append(letter);
                continue;
            }
            char mappedLetter = hash(Character.toLowerCase(letter));
            if (Character.isUpperCase(letter)) {
                mappedLetter = Character.toUpperCase(mappedLetter);
            }
            sb.append(mappedLetter);
        }
        return sb.toString();
    }

    private static char hash(char letter) {
        return (char) (maxLetter - letter);
    }
}
