package onboarding;

import onboarding.problem3.ClapGame;
import onboarding.problem3.GameNumber;

public class Problem3 {
    public static int solution(int number) {
        GameNumber maxNumber = new GameNumber(number);
        return new ClapGame(maxNumber).getClapCount();
    }
}
