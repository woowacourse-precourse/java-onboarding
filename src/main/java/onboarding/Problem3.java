package onboarding;

import onboarding.problem3.ThreeSixNineGame;

public class Problem3 {
    public static int solution(int number) {
        ThreeSixNineGame threeSixNineGame = new ThreeSixNineGame(number);
        return threeSixNineGame.getResult();
    }
}
