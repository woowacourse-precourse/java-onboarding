package onboarding;

import onboarding.problem3.Check369;
import onboarding.problem3.ThreeSixNineGame;

public class Problem3 {
    public static int solution(int number) {
        ThreeSixNineGame threeSixNineGame = new ThreeSixNineGame(new Check369());
        return threeSixNineGame.do369(number);
    }
}
