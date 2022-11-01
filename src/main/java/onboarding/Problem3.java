package onboarding;

import onboarding.problem3.IMiniGame;
import onboarding.problem3.ThreeSixNineGame;
import onboarding.problem3.ThreeSixNine;

public class Problem3 {
    public static int solution(int number) {
        if(number < 1 || number > 10000){
            throw new IllegalArgumentException("유효하지 않은 게임 범위");
        }

        IMiniGame<ThreeSixNine> game = new ThreeSixNineGame();
        ThreeSixNine result = game.run(ThreeSixNine.builder()
                        .startClapCount(0)
                        .executedClapCount(0)
                        .endClapCount(number)
                        .build());

        return result.getExecutedClapCount();
    }
}
