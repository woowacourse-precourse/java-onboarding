package onboarding;

import onboarding.problem4.Frog;

public class Problem4 {
    public static String solution(String word) {
        Frog frog = new Frog(word);
        return frog.speak();
    }
}
