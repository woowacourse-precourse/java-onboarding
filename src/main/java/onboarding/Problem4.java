package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {
    public static String solution(String word) {
        Map<Character, Character> map = insertIntoMap();
        String answer = "";
        answer = getReverseString(map, word);
        return answer;
    }
    private static String getReverseString(Map<Character, Character> map, String word) {
        char[] words = toCharArray(word);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            char alphabet = words[i];
            if(alphabet == ' ' ) {
                sb.append(" ");
            }
            else {
                sb.append(map.get(alphabet));
            }
        }
        return sb.toString();
    }
    private static Map<Character, Character> insertIntoMap() {
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i <= 'z' - 'a'; i++) {
            map.put((char) ('a' + i), (char) ('z' - i));
            map.put((char) ('A' + i), (char) ('Z' - i));
        }
        return map;
    }
    private static char[] toCharArray(String word) {
        return word.toCharArray();
    }
}
