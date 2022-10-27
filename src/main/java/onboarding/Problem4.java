package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {
    static Map<Character, Character> lowAlphaDictionary = new HashMap<>();
    static Map<Character, Character> upAlphaDictionary = new HashMap<>();
    public static String solution(String word) {
        String answer = "";

        initAlphabetDictionary();
        answer = convertString(word);

        return answer;
    }

    private static void initAlphabetDictionary() {
        for (int i = 97, j = 65; i < 123; i++, j++) {
            lowAlphaDictionary.put(Character.valueOf((char) i), Character.valueOf((char) (219 - i)));
            upAlphaDictionary.put(Character.valueOf((char) j), Character.valueOf((char) (155 - j)));
        }
    }

    private static String convertString(String word) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char token = word.charAt(i);
            if ((int) token <= 90 && (int) token >= 65) {// 대문자라면
                sb.append(upAlphaDictionary.get(token));
            } else if ((int) token >= 97 && token <= 122) {
                sb.append(lowAlphaDictionary.get(token));
            } else if (token == ' ') {
                sb.append(" ");
            } else sb.append(token);
        }

        return sb.toString();
    }

}
