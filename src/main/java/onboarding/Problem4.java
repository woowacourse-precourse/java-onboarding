package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {
    public static String solution(String word) {
        Map<Character, Character> frogDictionary = new HashMap<>();
        String answer = "";

        for (int i = 0; i < 26; i++) {
            Character alpha = (char) ('A' + i);
            frogDictionary.put(alpha, (char)('Z' - i));
        }

        for (int i = 0; i < word.length(); i++) {
            char curChar = word.charAt(i);
            // 알파벳 외의 문자는 변환하지 않는다.
            if ( !isAlpha(curChar) ) {
                answer += curChar;
                continue;
            }

            // 알파벳 소문자는 알파벳 소문자로 변환한다.
            if ( Character.isLowerCase(curChar) ) {
                char upperCurChar = Character.toUpperCase(curChar);
                char convertedCurChar = frogDictionary.get(upperCurChar);
                char lowerConvertedCurChar = Character.toLowerCase(convertedCurChar);
                answer += lowerConvertedCurChar;
            }
            // 알파벳 대문자는 알파벳 대문자로 변환한다.
            else if ( Character.isUpperCase(curChar) ) {
                char convertedCurChar = frogDictionary.get(curChar);
                answer += convertedCurChar;
            }
        }

        return answer;
    }

    static boolean isAlpha(char c) {
        if ( ('A' <= c && c <= 'Z') || ('a' <= c && c <= 'z') )
            return true;
        else
            return false;
    }
}
