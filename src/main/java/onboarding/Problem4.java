package onboarding;

import java.util.HashMap;

public class Problem4 {
    private static final HashMap<Character, Character> map = new HashMap<>();

    public static String solution(String word) {
        initMap();

        return "";
    }


    private static void initMap() {
        for (int i = 'A', j = 25; i <= 'Z'; i++, j-=2) {
            // Lower Case
            map.put((char)(i), (char)(i + j));

            // Upper Case
            map.put((char)(i + 32), (char)(i + 32 + j));
        }
    }


}
