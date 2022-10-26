package onboarding;

import onboarding.problem3.Clap369Game;
import onboarding.problem3.ClapGame;

public class Problem3 {
    public static int solution(int number) {
        ClapGame game = new Clap369Game(number);
        return game.getResult();
    }
}
