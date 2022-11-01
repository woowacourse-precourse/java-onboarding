package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {

    static final int ASCII_a = 97;
    static final int ASCII_z = 122;
    static final int ASCII_A = 65;
    static final int ASCII_Z = 90;

    public static String solution(String word) {

        StringBuilder answer = new StringBuilder();

        Map<Character, Character> lowerMap = createMap(ASCII_a, ASCII_z);
        Map<Character, Character> upperMap = createMap(ASCII_A, ASCII_Z);

        for (int i = 0; i < word.length(); i++) {
            if (ASCII_a <= word.charAt(i) && word.charAt(i) <= ASCII_z) {
                answer.append(oppositeLower(word.charAt(i), lowerMap));
            } else if (ASCII_A <= word.charAt(i) && word.charAt(i) <= ASCII_Z) {
                answer.append(oppositeUpper(word.charAt(i), upperMap));
            } else {
                answer.append(word.charAt(i));
            }
        }

        return answer.toString();
    }

    public static Map<Character, Character> createMap(int startAscii, int endAscii) {

        Map<Character, Character> wordMap = new HashMap<>();

        int end = endAscii;
        for (int i = startAscii; i <= endAscii; i++) {
            wordMap.put((char)i, (char)end--);
        }
        return wordMap;
    }

    public static Character oppositeUpper(Character upperCharacter, Map<Character, Character> upperMap) {
        return upperMap.get(upperCharacter);
    }

    public static Character oppositeLower(Character lowerCharacter, Map<Character, Character> lowerMap) {
        return lowerMap.get(lowerCharacter);
    }

}
