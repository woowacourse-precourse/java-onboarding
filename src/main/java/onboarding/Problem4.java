package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {
    private static final Map<Character, Character> frogdict = new HashMap<>();
    public static String solution(String word) {
        if (isValid(word)) {
            makeFrogDict();
            String answer = convertAlpha(word);
            return answer;
        } else
            return ""; // word의 길이가 주어진 범위를 벗어났을때
    }
    static void makeFrogDict(){
        for (int i = 0; i < 25; i++) {
            frogdict.put((char) ('A' + i), (char) ('Z' - i));
        }
    }

    static String convertAlpha(String word) {
        StringBuilder result = new StringBuilder();
        for (char c : word.toCharArray()) {
            if (!(c >= 'A' && c <= 'Z') && !(c >= 'a' && c <= 'z')) { // 알파벳 외의 문자는 변환하지 않는다.
                result.append(c);
            } else if (Character.isLowerCase(c)) {
                result.append(lowerCaseAlpha(c));
            } else {
                result.append(upperCaseAlpha(c));
            }
        }
        return result.toString();

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
        return len >= 1 && len <= 1000;
    }
}
