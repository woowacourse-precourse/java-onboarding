package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {
    static Map<Character, Character> dictionary = new HashMap<>();

    public static String solution(String word) {
        dictionary();
        return "";
    }

    /**
     * 청개구리 사전 만들기
     */
    public static void dictionary() {
        for (int i = 97; i <= 122; i++) {
            dictionary.put((char)i, (char)(219-i));
        }
    }
}
