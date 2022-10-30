package onboarding.problem1.result;

import onboarding.problem.ProblemResult;

public class Problem1Result implements ProblemResult<Integer> {

    private static final int FOBI_WIN = 1;

    private static final int CRONG_WIN = 2;

    private static final int DRAW = 0;

    private final int result;

    public Problem1Result(int pobiScore, int crongScore) {
        this.result = decideWinner(pobiScore, crongScore);
    }

    private int decideWinner(int pobiScore, int crongScore) {
        if (crongScore == pobiScore) {
            return DRAW;
        }
        return (pobiScore < crongScore)
                ? CRONG_WIN
                : FOBI_WIN;
    }

    @Override
    public Integer toResult() {
        return result;
    }
}
