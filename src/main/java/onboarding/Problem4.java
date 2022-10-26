package onboarding;

/**
 * goal: word가 주어질 때 청개구리 사전을 참고하여 반대로 변환한 값을 리턴
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 문제 풀이 순서
 * 1. map에 청개구리 사전을 a~z까지 등록한다.
 * 2. 주어진 word의 글자를 하나씩 확인하면서 청개구리 사전 map을 통해 문자열을 반환한다.
 */

public class Problem4 {
    enum AlphabetType {UPPER, LOWER,}

    public static String solution(String word) {
        String answer = "";
        Map<Character, String> treeFrogMap = new HashMap();
        createTreeFrogMap(treeFrogMap);
        return answer;
    }

    private static void createTreeFrogMap(Map<Character, String> treeFrogMap) {
        // 소문자 매핑
        char start = 'a';
        char end = 'z';
        mappingAlphabetToMap(treeFrogMap,AlphabetType.LOWER, start, end);

        // 대문자 매핑
        start = 'A';
        end = 'Z';
        mappingAlphabetToMap(treeFrogMap, AlphabetType.UPPER, start, end);
    }

    private static void mappingAlphabetToMap(Map<Character, String> treeFrogMap,
        AlphabetType alphabetType, char start, char end) {
        int idx = 0;
        for (int ascii = start; ascii <= end; ascii++) {
            char originValue = (char) ascii;
            String changeValue = "";
            if (alphabetType == AlphabetType.UPPER) {
                changeValue = String.valueOf((char) (end - idx++)).toLowerCase();
            }

            if (alphabetType == AlphabetType.LOWER) {
                changeValue = String.valueOf((char) (end - idx++)).toUpperCase();
            }

            treeFrogMap.put(originValue, changeValue);
        }
    }

}
