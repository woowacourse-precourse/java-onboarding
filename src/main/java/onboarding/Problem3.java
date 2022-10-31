package onboarding;


import onboarding.problem3.Game;

public class Problem3 {
    public static int solution(int number) {
        Game game = new Game(number);
        return game.getResult();
    }
}
