package onboarding;

import onboarding.problemthree.domain.Game;

public class Problem3 {
    public static int solution(int number) {

        Game game = new Game(number);

        int answer = game.play();
        return answer;
    }
}
