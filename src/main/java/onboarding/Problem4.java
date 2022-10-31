package onboarding;

import onboarding.problem4.ReverseGenerator;

public class Problem4 {
    public static String solution(String word) {
        ReverseGenerator generator = new ReverseGenerator();
        return generator.reverse(word);
    }
}
