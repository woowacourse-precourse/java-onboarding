package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {

    /**
     * 엄마 말씀 word가 매개변수로 주어질 때, 아래 청개구리 사전을 참고해 반대로 변환하여 return 하도록 solution 메서드를 완성하라.
     * @param word 원본 String
     * @return 규칙에 맞게 변환한 String
     */
    public static String solution(String word) {
        TreeFrog treeFrog = new TreeFrog();
        return treeFrog.say(word);
    }
}

class TreeFrog {
    private final Map<Character, Character> wordSwitchRule = new HashMap<>();

    public TreeFrog() {

        for (int i = 0; i < 26; i++) {
            wordSwitchRule.put((char)('a' + i), (char)('z' - i));
            wordSwitchRule.put((char)('A' + i), (char)('Z' - i));
        }
    }

    public String say(String word) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            ch = treeFrogRule(ch);
            sb.append(ch);
        }

        return sb.toString();
    }

    private char treeFrogRule(char ch) {
        return wordSwitchRule.getOrDefault(ch, ch);
    }
}