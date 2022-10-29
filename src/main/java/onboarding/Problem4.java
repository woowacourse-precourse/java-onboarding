package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {
    public static String solution(String word) {
        Map<Character, Character> wordMap = new HashMap<>();

        char upperA = 'A';
        char lowerA = 'a';

        // 알파벳의 길이
        int dictionaryLength = 26;
        for (int i = 0; i < dictionaryLength; i++) {
            wordMap.put((char) (upperA + i), (char) (upperA + 25 - i));
            wordMap.put((char) (lowerA + i), (char) (lowerA + 25 - i));
        }

        // StringBuilder를 사용한 문자열 합치기
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char w = word.charAt(i);
            if (w == ' ') {
                result.append(w);
                continue;
            }
            result.append(wordMap.get(w));
        }
        return result.toString();
    }
}
