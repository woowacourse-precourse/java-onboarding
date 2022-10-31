package onboarding;

import onboarding.problem1.Page;

import java.util.List;

class Problem1 {
    private static final int POBI_WIN = 1;
    private static final int CRONG_WIN = 2;
    private static final int DRAW = 0;
    private static final int EXCEPTION = -1;


    public static int solution(List<Integer> pobi, List<Integer> crong) {
        try {
            Page pobiPage = new Page(pobi);
            Page crongPage = new Page(crong);

            int pobiMaxResult = pobiPage.getMaxLeftAndRight();
            int crongMaxResult = crongPage.getMaxLeftAndRight();

            return getWinner(pobiMaxResult, crongMaxResult);

        } catch (IllegalArgumentException e) {
            return EXCEPTION;
        }

    }

    private static int getWinner(int pobiResult, int crongResult) {
        if (pobiResult > crongResult) {
            return POBI_WIN;
        }
        if (pobiResult < crongResult) {
            return CRONG_WIN;
        }
        return DRAW;
    }
}