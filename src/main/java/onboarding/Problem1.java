package onboarding;

import onboarding.problem1.BookPageDiscriminator;
import onboarding.problem1.BookScoreCalculator;

import java.util.Arrays;
import java.util.List;

public class Problem1 {

    private static final int POBI_WIN = 1;
    private static final int CRONG_WIN = 2;
    private static final int DRAW = 0;
    private static final int EXCEPTIONAL_CIRCUMSTANCES = -1;

    public static int solution(List<Integer> pobi, List<Integer> crong) {

        if (!BookPageDiscriminator.isProperBookPage(pobi, crong)){
            return EXCEPTIONAL_CIRCUMSTANCES;
        }

        int pobiScore = BookScoreCalculator.score(pobi);
        int crongScore = BookScoreCalculator.score(crong);

        if (pobiScore > crongScore) return POBI_WIN;
        if (pobiScore < crongScore) return CRONG_WIN;
        return DRAW;
    }
}