package onboarding;

import java.util.Map;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
    }

    static class ConvertMap{
        private final Map<Character, Character> convertMap;

        public ConvertMap(Map<Character, Character> convertMap) {
            this.convertMap = convertMap;
        }

        public char getConvertedLetter(char letter) {
            return convertMap.get(letter);
        }

    }
}
