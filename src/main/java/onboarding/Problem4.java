package onboarding;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem 4
 *
 * 기능 요구 사항
 * 1. 청개구리 사전 사용
 * 2. word가 주어지면 사전을 참고하여 반대로 변환
 *
 * 제한 사항
 * 1. word 길이는 1이상 1000이하
 * 2. 알파벳 외의 문자는 변환하지 않는다.
 * 3. 대문자는 대문자, 소문자는 소문자로
 */
public class Problem4 {
    /**
     *
     * @param word
     * @return 변환된 word값
     */
    public static String solution(String word) {
        String answer = "";
        StringBuilder ans = new StringBuilder(word);
        Map<Character, Character> dictionary = makeDictionary();

        return answer;
    }

    /**
     *
     * @return 각 알파벳에 맞는 단어 값
     */
    public static Map<Character, Character> makeDictionary() {
        Map<Character, Character> dictionary = new HashMap<>();
        for (int i=0; i<32; i++){
            dictionary.put((char)('A'+i), (char)('Z'- i));
            dictionary.put((char)('a'+i), (char)('z'- i));
        }
        return dictionary;
    }
}
