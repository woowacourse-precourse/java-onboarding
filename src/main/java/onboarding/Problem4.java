package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {
    private final static Map<Character, Character> wordSwitchRule;

    static {
        wordSwitchRule = new HashMap<>();

        for (int i = 0; i < 26; i++) {
            wordSwitchRule.put((char)('a' + i), (char)('z' - i));
            wordSwitchRule.put((char)('A' + i), (char)('Z' - i));
        }
    }

    private static void mamaWordTransformation(char[] treeFrogSay, String word) {

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            ch = treeFrogRule(ch);
            treeFrogSay[i] = ch;
        }
    }

    private static char treeFrogRule(char ch) {
        return wordSwitchRule.getOrDefault(ch, ch);
    }

    /**
     * 엄마 말씀 word가 매개변수로 주어질 때, 아래 청개구리 사전을 참고해 반대로 변환하여 return 하도록 solution 메서드를 완성하라.
     * @param word 원본 String
     * @return 규칙에 맞게 변환한 String
     */
    public static String solution(String word) {
        char[] treeFrogSay = new char[word.length()];
        mamaWordTransformation(treeFrogSay, word);
        return new String(treeFrogSay);
    }
}
