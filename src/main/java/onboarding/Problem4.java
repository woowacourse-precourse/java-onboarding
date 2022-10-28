package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {
    public static String solution(String word) {
        FrogDictionary frogDictionary = new FrogDictionary();

        return frogDictionary.convertToFrogString(word);
    }

    // 청개구리 사전 클래스
    private static class FrogDictionary {
        private final int ALPHABET_SIZE = 26;
        private Map<Character, Character> dictionary;

        public FrogDictionary() {
            initDictionary();
        }

        // 청개구리 사전 규칙에 맞게 초기화한다.
        private void initDictionary() {
            dictionary = new HashMap<>();
            for (int i = 0; i < ALPHABET_SIZE; i++) {
                dictionary.put((char) ('A' + i), (char) ('Z' - i));
                dictionary.put((char) ('a' + i), (char) ('z' - i));
            }
        }

        // 사전을 이용해서 청개구리 문자열로 변환한다.
        public String convertToFrogString(String string) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < string.length(); i++) {
                stringBuilder.append(dictionary.getOrDefault(string.charAt(i),
                                                            string.charAt(i)));
            }
            return stringBuilder.toString();
        }
    }
}
