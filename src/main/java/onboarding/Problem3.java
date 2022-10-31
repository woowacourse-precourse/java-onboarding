package onboarding;

import onboarding.problem3.ClapGame;

public class Problem3 {

    public static int solution(int number) {
        ClapGame clapGame = new ClapGame();
        return clapGame.getClap(number);
    }

}
