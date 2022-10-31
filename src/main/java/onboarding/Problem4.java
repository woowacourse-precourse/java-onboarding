package onboarding;

import java.util.HashMap;

public class Problem4 {
    private static final HashMap<Character, Character> map = new HashMap<>();
    private static boolean isFirstInit = true;

    public static String solution(String word) {
        if (isFirstInit) {
            initMap();
            isFirstInit = false;
        }

        return wordConvertByMap(word);
    }


    private static void initMap() {
        for (int i = 'A', j = 25; i <= 'Z'; i++, j-=2) {
            // Lower Case
            map.put((char)(i), (char)(i + j));

            // Upper Case
            map.put((char)(i + 32), (char)(i + 32 + j));
        }
    }


    private static String wordConvertByMap(String word) {
        StringBuffer buffer = new StringBuffer();

        for (char ch : word.toCharArray()) {
            buffer.append(map.getOrDefault(ch, ch));
        }

        return buffer.toString();
    }
}
