package onboarding;

import onboarding.problem1.service.ScoreService;
import onboarding.problem1.vo.Score;

import java.util.List;

class Problem1 {
    public static final int EXCEPTION_RETURN_VALUE = -1;
    public static final int POBI_WINNER_RETURN_VALUE = 1;
    public static final int CRONG_WINNER_RETURN_VALUE = 2;
    public static final int TIE = 0;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        try {
            Score pobiScore = ScoreService.getHighestScore(pobi);
            Score crongScore = ScoreService.getHighestScore(crong);

            if (pobiScore.isHigherThan(crongScore)) {
                return POBI_WINNER_RETURN_VALUE;
            } else if (pobiScore.isLowerThan(crongScore)) {
                return CRONG_WINNER_RETURN_VALUE;
            }

            return TIE;
        } catch (IllegalArgumentException exception) {
            return EXCEPTION_RETURN_VALUE;
        }
    }
}
