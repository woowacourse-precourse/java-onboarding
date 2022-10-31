package onboarding;

import onboarding.problem1.PageGame;
import onboarding.problem1.PageScore;
import onboarding.problem1.impl.PageGameV1;
import onboarding.problem1.impl.PageScoreV1;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        PageScore pobiScore = new PageScoreV1(pobi);
        PageScore crongScore = new PageScoreV1(crong);
        PageGame game = new PageGameV1(pobiScore, crongScore);
        return game.getResult();
    }
}