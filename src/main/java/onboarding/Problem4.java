package onboarding;

import onboarding.problem4.AlphabetConverter;

public class Problem4 {
    public static String solution(String word) {
        AlphabetConverter alphabetConverter = new AlphabetConverter(word);
        return alphabetConverter.convert();
    }
}
