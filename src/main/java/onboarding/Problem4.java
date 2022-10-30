package onboarding;

import java.util.HashMap;
import java.util.Map;

/*
1. 알파벳 초기화
2. 대문자, 소문자 변환하기
 */

public class Problem4 {

    private static Map<Character, Character> getUpperCaseMap() {
        Map<Character, Character> alphabet = new HashMap<>();
        char A = 'A';
        char Z = 'Z';
        for (int i = 0; i < 26; i++) {
            alphabet.put((char)('A' + i), (char)('Z' - i));
        }
        return alphabet;
    }

    private static Map<Character, Character> getLowerCaseMap() {
        Map<Character, Character> alphabet = new HashMap<>();
        char a = 'a';
        char z = 'z';
        for (int i = 0; i < 26; i++) {
            alphabet.put((char)('a' + i), (char)('z' - i));
        }
        return alphabet;
    }

    public static String solution(String word) {
        String answer = "";
        Map<Character, Character> upperCaseMap =  getUpperCaseMap();
        Map<Character, Character> lowerCaseMap =  getLowerCaseMap();
        for (char element : word.toCharArray()) {
            if ('A' <= element && element <= 'Z') {
                answer += upperCaseMap.get(element);
            }
            if ('a' <= element && element <= 'z') {
                answer += lowerCaseMap.get(element);
            }
            if (!('A' <= element && element <= 'Z') && !('a' <= element && element <= 'z')) {
                answer += element;
            }
        }
        return answer;
    }
}
