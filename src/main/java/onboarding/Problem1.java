package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        try {
            checkException(pobi);
            checkException(crong);

            int pobiScore = calMaxScore(pobi);
            int crongScore = calMaxScore(crong);

            return findWinner(pobiScore, crongScore);

        } catch (RuntimeException e) {
            return -1;
        }
    }
}
