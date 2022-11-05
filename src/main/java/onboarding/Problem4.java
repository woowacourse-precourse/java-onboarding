package onboarding;

import onboarding.problem4.AlphabetConverter;
import onboarding.problem4.FrogConverter;

public class Problem4 {

    private static final AlphabetConverter converter = new FrogConverter();

    public static String solution(String word) {

        // converter 객체를 이용해 word를 변환함.
        return converter.convertWord(word);
    }
}


