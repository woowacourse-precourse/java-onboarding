package onboarding;

import onboarding.problem3.ApplauseGame;
import onboarding.problem3.ClapRule;

public class Problem3 {
    public static int solution(int number) {
        ClapRule clapRule = new ClapRule();
        return ApplauseGame.start(number, clapRule);
    }
}
