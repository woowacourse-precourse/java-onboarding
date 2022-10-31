package onboarding;

import java.util.List;
import onboarding.problem1.Score;

class Problem1 {
    private static final int DRAW = 0;
    private static final int POBI_WIN = 1;
    private static final int CRONG_WIN = 2;
    private static final int EXCEPTION = -1;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        try {
            Score pobiScore = new Score(pobi);
            Score crongScore = new Score(crong);

            int maxScoreForPobi = pobiScore.getMaxScore();
            int maxScoreForCrong = crongScore.getMaxScore();

            if (maxScoreForPobi == maxScoreForCrong) {
                return DRAW;
            }
            return maxScoreForPobi > maxScoreForCrong ? POBI_WIN : CRONG_WIN;
        } catch (Exception e) {
            return EXCEPTION;
        }
    }
}