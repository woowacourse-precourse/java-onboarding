package onboarding;

import onboarding.problem4.domain.Sentence;

public class Problem4 {
    public static String solution(String word) {
        return new Sentence(word).convert();
    }
}
