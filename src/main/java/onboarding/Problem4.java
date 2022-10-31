package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {
    // A -> Z, Z -> A 로 변환하는 Map을 세팅하는 함수
    public static void mapSet(Map<Character, Character> map) {
        char small = 'a';
        char capital = 'A';
        int maxlen = 'Z' - 'A';

        for (int i=0; i<maxlen; i++) {
            map.put(small++, (char)('z' - i));
            map.put(capital++, (char) ('Z' - i));
        }
    }
    public static String solution(String word) {
        String answer = "";
        return answer;
    }
}
