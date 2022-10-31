package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {
    public static String solution(String word) {
        Map<String, String> lowerAlphabetHashMap = new HashMap<>();     // 소문자 Key-Value 쌍
        Map<String, String> upperAlphabetHashMap = new HashMap<>();     // 대문자 Key-Value 쌍
        for (int i = 0; i < 26; i++) {
            String lowerAlphabetKey = Character.toString((char)((int)'a' + i));         // Key, 소문자 a-z 순서
            String upperAlphabetKey = Character.toString((char)((int)'A' + i));         // Key, 대문자 A-Z 순서
            String lowerAlphabetValue = Character.toString((char)((int)'z' - i));       // Value, 소문자 z-a 순서
            String upperAlphabetValue = Character.toString((char)((int)'Z' - i));       // Value, 대문자 Z-A 순서

            lowerAlphabetHashMap.put(lowerAlphabetKey, lowerAlphabetValue);     // 소문자 Key-Value 쌍 추가
            upperAlphabetHashMap.put(upperAlphabetKey, upperAlphabetValue);     // 소문자 Key-Value 쌍 추가
        }

        String answer = "";
        for (int i = 0; i < word.length(); i++) {               // 주어진 문자열의 각 자리에 대해
            char letter = word.charAt(i);                       // 현재 자리 문자
            if (Character.isUpperCase(letter)) {                // 현재 자리 문자가 대문자이면
                String key = Character.toString(letter);        // 현재 자리 문자를 문자열로 변환
                answer += upperAlphabetHashMap.get(key);        // 대문자 Key-Value 사전에서 Value 추출 및 삽입
            } else if (Character.isLowerCase(letter)) {         // 현재 자리 문자가 소문자이면
                String key = Character.toString(letter);        // 현재 자리 문자를 문자열로 변환
                answer += lowerAlphabetHashMap.get(key);        // 소문자 Key-Value 사전에서 Value 추출 및 삽입
            } else {                                            // 그 외 공백이나 특수문자의 경우
                answer += Character.toString(letter);           // 그대로 삽입
            }
        }

        return answer;
    }
}
