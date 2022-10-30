package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {

    static final char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    public static String solution(String word) {
        String answer = "";
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < alphabet.length; i++) {
            map.put(alphabet[i], alphabet[alphabet.length - i - 1]);
            map.put(Character.toUpperCase(alphabet[i]),
                Character.toUpperCase(alphabet[alphabet.length - i - 1]));
        }

        for (char letter :
            word.toCharArray()) {
            if (letter == ' ') {
                answer += ' ';
            } else {
                answer += map.get(letter);
            }
        }
        return answer;
    }
}
