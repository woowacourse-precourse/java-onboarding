package onboarding;

import onboarding.prob4.domain.Frog;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        Frog frog = new Frog();
        answer = frog.solve(word);
        return answer;
    }
}
