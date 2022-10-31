package onboarding;

import java.util.HashMap;
import java.util.Map;

class TreeFrog {
    /**
     * 개구리마다 각자의 번역 사전이 있을 수 있다.
     * 따라서, 인스턴스를 생성해서 매소드를 호출하는 것이 좋다.
     */

    private Map<Character, Character> lowerCaseDictionary = new HashMap<>();
    private Map<Character, Character> upperCaseDictionary = new HashMap<>();

    public TreeFrog() { // frog 자체의 사전을 정의
        for (int i = 0; i < 26; i++) {
            lowerCaseDictionary.put((char) ('a' + i), (char) ('z' - i));
            upperCaseDictionary.put((char) ('A' + i), (char) ('Z' - i));
        }
    }
}

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
    }
}
