package onboarding;

import java.util.HashMap;

/**
 * [ ] 알파벳 외의 문자는 변환하지 않는다.
 * [ ] word를 청개구리 사전을 참고해 반대로 변환한다.
 * [ ] 알파벳 대문자는 대문자로, 알파벳 소문자는 소문자로 변환한다.
 */
public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        HashMap<Character, Character> treeFrogDict = replaceOtherCharDict();

        return "";
    }

    public static HashMap replaceOtherCharDict() {
        HashMap<Character, Character> treeFrogDict = new HashMap<>(26);

        for (int i = 65; i <= 90; i++) {
            char originalWord = (char) i;
            char replaceWord = (char) (155 - i);

            treeFrogDict.put(originalWord, replaceWord);
        }

        return treeFrogDict;
    }
}
