package onboarding;

import onboarding.domain.Score;

import java.util.List;

class Problem1 {
    public static final int EXCEPTION = -1;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        try {
            Score pobiScore = new Score(pobi);
            Score crongScore = new Score(crong);
            return pobiScore.playGame(crongScore);
        } catch (IllegalArgumentException e) {
            return EXCEPTION;
        }
    }
}