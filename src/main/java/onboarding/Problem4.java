package onboarding;

import onboarding.domain.problem4.Frog;

public class Problem4 {
    public static String solution(String word) {
        Frog frog = new Frog(word);
        return frog.say();
    }
}
