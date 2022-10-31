package onboarding;

import onboarding.problem4.AlphabetConverter;
import onboarding.problem4.FrogConverter;

public class Problem4 {

    private static final AlphabetConverter converter = new FrogConverter();

    public static String solution(String word) {

        return converter.convertWord(word);
    }
}


