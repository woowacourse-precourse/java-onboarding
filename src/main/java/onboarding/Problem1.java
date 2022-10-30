package onboarding;

import onboarding.problem1.Pages;

import java.util.List;

class Problem1 {
    private static final int POBI_WIN = 1;
    private static final int CRONG_WIN = 2;
    private static final int DRAW = 0;
    private static final int EXCEPTION = -1;


    public static int solution(List<Integer> pobi, List<Integer> crong) {
        try {
            Pages pobiPages = new Pages(pobi);
            Pages crongPages = new Pages(crong);

            int pobiMaxResult = pobiPages.getMaxLeftAndRight();
            int crongMaxResult = crongPages.getMaxLeftAndRight();

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