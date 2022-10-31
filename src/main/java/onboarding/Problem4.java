package onboarding;

import problem4.WordConverter;

public class Problem4 {
    public static String solution(String word) {
        try {
            return WordConverter.convert(word);
        } catch (RuntimeException e) {
            return word;
        }
    }
}
