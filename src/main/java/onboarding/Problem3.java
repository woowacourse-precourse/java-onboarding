package onboarding;

import model.ClapGame;

public class Problem3 {
    public static int solution(int number) {
        ClapGame clapGame = new ClapGame(number);
        clapGame.start();
        return clapGame.getClapNumber();
    }
}
