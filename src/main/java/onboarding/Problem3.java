package onboarding;

import onboarding.problem3.Game369;

public class Problem3 {
    public static int solution(int number) {
        Game369 game369 = new Game369();
        game369.playTheGame(number);
        return game369.getClapCount();
    }
}
