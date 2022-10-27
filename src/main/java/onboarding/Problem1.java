package onboarding;

import onboarding.problem1.PageValidator;
import onboarding.problem1.ScoreCalculator;

import java.util.List;

class Problem1 {

    public static final int DRAW = 0;
    public static final int POBI_WIN = 1;
    public static final int CRONG_WIN = 2;
    public static final int EXCEPTION_SITUATION = -1;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        PageValidator pageValidator = new PageValidator();
        try {
            pageValidator.validatePages(pobi);
            pageValidator.validatePages(crong);
        } catch (IllegalArgumentException e) {
            return EXCEPTION_SITUATION;
        }

        return getResultOfGame(pobi, crong);
    }

    private static int getResultOfGame(List<Integer> pobi, List<Integer> crong) {
        final int pobiScore = ScoreCalculator.calculate(pobi);
        final int crongScore = ScoreCalculator.calculate(crong);
        if (pobiScore == crongScore) {
            return DRAW;
        } else if (pobiScore > crongScore) {
            return POBI_WIN;
        }
        return CRONG_WIN;
    }
}