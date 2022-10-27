package onboarding;

import java.util.HashMap;
import java.util.Map;

/**
 * 기능 요구사항
 * 1. 청개구리 사전을 구현한다.
 * 2. 주어진 word를 반대로 변환해야 한다.
 */
public class Problem4 {
    static Map<Character, Character> frogDictionary;
    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();
        frogDictionary = new HashMap<>();
        makingDictionary();
        return answer.toString();
    }

    private static void makingDictionary() {
        int tmp = 90;
        for(int i=65;i<=90;i++){
            frogDictionary.put((char) i, (char) tmp--);
        }
    }
}
