package onboarding;

import onboarding.problem3.objects.Game;

public class Problem3 {
    public static int solution(int number) {
        try {
            Game game = new Game(number);
            return game.start();
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }
}
