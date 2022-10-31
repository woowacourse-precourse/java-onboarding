package onboarding;

import onboarding.problem1.Calculator;
import onboarding.problem1.Pages;

import java.util.List;

class Problem1 {
    private static final int EXCEPTION = -1;
    private static final int POBI_WIN = 1;
    private static final int CRONG_WIN = 2;
    private static final int TIE = 0;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        Pages pobiChoice = new Pages(pobi);
        Pages crongChoice = new Pages(crong);
        if (pobiChoice.isIllegal() || crongChoice.isIllegal()) {
            return EXCEPTION;
        }

        int pobiScore = new Calculator(pobiChoice).getScore();
        int crongScore = new Calculator(crongChoice).getScore();

        if (pobiScore > crongScore) {
            return POBI_WIN;
        }
        if (pobiScore == crongScore) {
            return TIE;
        }
        return CRONG_WIN;
    }
}