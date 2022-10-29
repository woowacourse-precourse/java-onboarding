package onboarding;

import java.util.HashMap;

public class Problem4 {
    public static String solution(String word) {
        final String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        final String lowerCase = "abcdefghijklmnopqrstuvwxyz";

        HashMap<Character, Character> frogMap = new HashMap<>();
        for (int i = 0; i < upperCase.length() - 1; i += 1) {
            frogMap.put(upperCase.charAt(i), upperCase.charAt(upperCase.length() - 1 - i));
            frogMap.put(lowerCase.charAt(i), lowerCase.charAt(lowerCase.length() - 1 - i));
        }

        String answer = "";

        return answer;
    }
}
