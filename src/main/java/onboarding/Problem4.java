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

    private static final Map<Character, Character> treeFrogMap = new HashMap<>();

    public static String solution(String word) {
        createTreeFrogMap();
        return changeWordWithTreeFrogMap(word);
    }

    private static String changeWordWithTreeFrogMap(String word) {
        StringBuilder changeWord = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char current = word.charAt(i);
            if (current == ' ') {
                changeWord.append(current);
                continue;
            }
            changeWord.append(treeFrogMap.get(word.charAt(i)));
        }
        return changeWord.toString();
    }

    private static void createTreeFrogMap() {
        // 소문자 매핑
        char start = 'a';
        char end = 'z';
        mappingAlphabetToMap(start, end);

        // 대문자 매핑
        start = 'A';
        end = 'Z';
        mappingAlphabetToMap(start, end);
    }

    private static void mappingAlphabetToMap(char start, char end) {
        int idx = 0;
        for (int ascii = start; ascii <= end; ascii++) {
            char originValue = (char) ascii;
            char changeValue = (char) (end - idx++);
            treeFrogMap.put(originValue, changeValue);
        }
    }

}
