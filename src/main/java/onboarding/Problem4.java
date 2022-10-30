package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {
    private static Map<Character, Character> map = new HashMap<>();
    public static String solution(String word) {
        String answer = "";
        answer = getReverseString(word);
        return answer;
    }
    private static String getReverseString(String word) {
        char[] words = toCharArray(word);
        insertIntoMap();
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
    private static void insertIntoMap() {
        for (int i = 0; i <= 'z' - 'a'; i++) {
            map.put((char) ('a' + i), (char) ('z' - i));
            map.put((char) ('A' + i), (char) ('Z' - i));
        }
    }
    private static char[] toCharArray(String word) {
        return word.toCharArray();
    }
}
