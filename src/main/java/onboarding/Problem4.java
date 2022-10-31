package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {
    private static Map<Character, Character> frogdict = new HashMap<>();
    public static String solution(String word) {
        if (isValid(word)) {
            makeFrogDict();
            String answer = "";
            return answer;
        } else
            return ""; // word의 길이가 주어진 범위를 벗어났을때
    }
    static void makeFrogDict(){
        for (int i = 0; i < 25; i++) {
            frogdict.put((char) ('A' + i), (char) ('Z' - i));
        }
    }

    static char upperCaseAlpha(char alpha) {
        // 대문자 알파벳 정반대로 바꾸기
        return frogdict.get(alpha);
    }

    static char lowerCaseAlpha(char alpha) {
        // 소문자 알파벳 정반대로 바꾸기
        char alpha_value = frogdict.get(Character.toUpperCase(alpha));
        alpha_value = Character.toLowerCase(alpha_value);
        return alpha_value;
    }

    static boolean isValid(String word) {
        int len = word.length();
        if (len < 1 || len > 1000)
            return false;
        else
            return true;
    }
}
