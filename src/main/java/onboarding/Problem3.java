package onboarding;

import onboarding.domain.Game369;

public class Problem3 {
    public static int solution(int number) {
        Game369 game369 = new Game369(number);
        return game369.getGameResult();
    }
}
