package onboarding;

import onboarding.problem3.objects.Game;
import onboarding.problem3.objects.Rule;

public class Problem3 {
    public static int solution(int number) {
        try {
            Game game = new Game(number, new Rule());
            return game.start();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }
}
