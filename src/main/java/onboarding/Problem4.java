package onboarding;

import onboarding.problem4.Frog;
import onboarding.problem4.TreeFrog;

public class Problem4 {
    public static String solution(String word) {
        Frog frog = new TreeFrog(word);
        return frog.repeatAfter();
    }
}
