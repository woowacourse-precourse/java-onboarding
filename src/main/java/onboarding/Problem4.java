package onboarding;

import onboarding.problem4.WordConverter;

public class Problem4 {
    public static String solution(String word) {
        WordConverter wordConverter = new WordConverter();
        return wordConverter.convertWord(word);
    }
}
